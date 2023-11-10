import pickle

import numpy as np
from flask import Flask, request, render_template

app = Flask(__name__, template_folder = 'template')
model = pickle.load(open('pred_model.pkl', 'rb'))
feat_ex = pickle.load(open('feat_ex.pkl', 'rb'))
 
@app.route('/')
def home():
    return render_template('index.html')
 
@app.route('/predict', methods=['POST'])
def predict():
    int_features = [request.form.get('email')]

    if not int_features:
        # Handle empty input
        return render_template('index.html', prediction_text='Please enter an email.')

    # Convert the NumPy array to a string and then to lowercase
    pre_final_features = [str(int_features[0]).lower()]
    final_features = feat_ex.transform(pre_final_features)

    prediction = model.predict(final_features)

    if prediction[0] == 1:
        output = "Spam"
    elif prediction[0] == 0:
        output = "Ham"
    else:
        output = "Not sure"  # Handle the "Not sure" case

    return render_template('index.html', prediction_text='This email is {}'.format(output))
 
 
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)