import os
import flask
import firebase_admin
from firebase_admin import db
from apscheduler.schedulers.background import BackgroundScheduler
from flask import request, jsonify
from numpy import cumproduct
from helper import reddit_api as rApi, text_nlp as npl, yfinance_api as yf

current_dir = os.path.dirname(os.path.abspath(__file__))
cred_obj = firebase_admin.credentials.Certificate(current_dir+'\canvas-antler-326322-firebase-adminsdk-92hda-251ccf610b.json')
default_app = firebase_admin.initialize_app(cred_obj, {
	'databaseURL': 'https://canvas-antler-326322-default-rtdb.firebaseio.com/'
	})

app = flask.Flask(__name__)
app.config["DEBUG"] = True

@app.route('/', methods=['GET'])
def home():
    return 'StockClock API v1'.encode()

@app.route('/prices', methods=['GET'])
def stockprices():
    results = {}
    if 'stocks' in request.args:
        print('-------->', type(request.args.get('stocks')))
        for i in request.args.get('stocks').split(' '):
            #db request for each i
            results[i] = 'price'+str(i)
    else:
        bad_request(400)
    return jsonify(results)

@app.route('/argument-test', methods=['GET'])
def argtest():
    results = {}
    for i in request.args:
        results[i] = request.args.get(i)
    return jsonify(results)

@app.errorhandler(404)
def page_not_found(e):
    return 'Unknown Path | StockClock API v1'.encode(), 404

@app.errorhandler(400)
def bad_request(e):
    return 'Bad request | StockClock API v1'.encode(), 400

def loopedRedditTask():
    pass

def loopedYFinanceTask():
    ref = db.reference('/stocks')
    stocks_all=ref.get()
    del stocks_all['TEST']
    for stock in stocks_all.keys():
        data = yf.getStockData(stock)
        if data == 0:
            continue
        else:
            ref = db.reference('/stocks/'+data['name'])
            ref.set(data)


print('Initializing Schedulers')
scheduler = BackgroundScheduler()
scheduler.add_job(loopedRedditTask, 'interval', hours=1)
scheduler.add_job(loopedYFinanceTask, 'interval', hours=24)
scheduler.start()
print('Completed Schedulers')


print('Initializing Reddit Task')
loopedRedditTask()
print('Completed Reddit Task')
print('Initializing YFinance Task')
loopedYFinanceTask()
print('Completed YFinance Task')
app.run(host='0.0.0.0', port=8080)