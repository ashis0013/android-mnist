import requests 
import base64
import curlify

def toBase64(filename):
    encodedString = ''
    with open(filename, 'rb') as img:
        encodedString = base64.b64encode(img.read())
    return encodedString

res = requests.post('https://mnist-flask-pytorch-ashis.herokuapp.com/predict', data={'file': toBase64('seven.png')})
print(toBase64('eight.png'))
