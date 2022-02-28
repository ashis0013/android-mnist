import requests 
import base64

def toBase64(filename):
    encodedString = ''
    with open(filename, 'rb') as img:
        encodedString = base64.b64encode(img.read())
    return encodedString

res = requests.post('http://127.0.0.1:5000/predict', data={'file': toBase64('seven.png')})
print(res.text)
