# MNIST Classifier

An android app that let's you classify handwritten digits. The project is WIP but the basic functionalities are working fine.
The classification is done using a simple convolutional neural network written in pytorch. The model is served using flask and hosted using heroku.
The API endpoint is publically available at `https://mnist-flask-pytorch-ashis.herokuapp.com/predict` (POST)

## Todo
- [ ] Add logo, splash and proper package name
- [ ] Improve backend. Add proper error handling and response
- [ ] Move the UI to jetpack compose
- [ ] Improve base64 conversion to deal with smaller drawings
- [ ] Add logging and devtooling (Flipper?)
- [ ] Publish on playstore

## Demo
<img width="450px" src="https://user-images.githubusercontent.com/31564734/157288912-ac7c1df1-d8a6-42ce-88ad-2e2cb9eae977.gif"/>
