from base64 import b64decode
from io import BytesIO
import torch 
import torch.nn as nn
import torch.nn.functional as F
import torchvision.transforms as transforms 
from PIL import Image

class Net(nn.Module):
    def __init__(self):
        super(Net,self).__init__()
        self.conv1 = nn.Conv2d(1,32,3,1,1)
        self.conv2 = nn.Conv2d(32,64,3,1,1)
        self.pool = nn.MaxPool2d(2,2)
        self.fc1 = nn.Linear(64*7*7,512)
        self.fc2 = nn.Linear(512,10)

    def forward(self,x):
        x = F.gelu(self.conv1(x))
        x = self.pool(x)
        x = F.gelu(self.conv2(x))
        x = self.pool(x) 
        x = x.view(-1,64*7*7)
        x = F.gelu(self.fc1(x))
        return self.fc2(x)

def transform_image(b64img):
    transform = transforms.Compose([transforms.Grayscale(num_output_channels=1),
                                    transforms.Resize((28,28)),
                                    transforms.ToTensor(),
                                    transforms.Normalize([0.5], [0.5])])
    imgBytes = b64decode(b64img)
    image = Image.open(BytesIO(imgBytes))
    return transform(image).unsqueeze(0)

def predictResult(b64img):
    model = Net()
    PATH = "app/model.pth"
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    model.load_state_dict(torch.load(PATH, map_location=device))
    model.eval()
    outputs = model(transform_image(b64img))
    _, predicted = torch.max(outputs.data, 1)
    return predicted
