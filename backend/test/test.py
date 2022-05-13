import requests 
import base64

def toBase64(filename):
    encodedString = ''
    with open(filename, 'rb') as img:
        encodedString = base64.b64encode(img.read())
    return encodedString

res = requests.post('http://mnist-flask-pytorch-ashis.herokuapp.com/predict', data={'image': toBase64('seven.png')})
print(res.text)
