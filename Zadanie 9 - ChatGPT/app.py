from flask import Flask, request, render_template, jsonify
# from openai import ChatCompletion, OpenAI
import openai
import os
import requests
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/ask', methods=['POST'])
def ask_question():
    data = request.json
    question = data.get("question")

    openai.api_key=os.environ.get('OPENAI_APIKEY')

    headers = {
        "Content-Type": "application/json",
        "Authorization": openai.api_key
    }


    messages = [{"role": "user", "content": question}]

    payload = {
        "model": "gpt-3.5-turbo",
        "messages": messages,
        "temperature": 0.7
    }

    response = requests.post("https://api.openai.com/v1/chat/completions", headers=headers, json=payload)
    response_data = response.json()

    if response.status_code == 200:
        answer = response_data["choices"][0]["message"]["content"]
        return jsonify({"question": question, "answer": answer}), 200

    else:
        error_message = response.json().get("error", "Unknown error")
        return jsonify({"error": error_message}), response.status_code


if __name__ == '__main__':
    app.run(debug=True)
