from flask import Flask, request, jsonify
from predictor import predictResult
app = Flask(__name__)

@app.route('/', methods = ['GET'])
def home():
    return "Hello\nUse predict/ endpoint to get the prediction"

@app.route('/predict', methods = ['POST'])
def predict():
    if request.method == 'POST':
        b64String = request.form['file']
        prediction = predictResult(b64String)
        return jsonify({'pred' : prediction.item()})

app.run()