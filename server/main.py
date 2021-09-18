import flask
from flask import request, jsonify

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

app.run(host='0.0.0.0', port=8080)