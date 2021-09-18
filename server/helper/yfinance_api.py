import yfinance as yf
import json

def getStockData(which):
    stock = yf.Ticker(which)
    hist = stock.history(period="max")
    hist = hist[-30:]
    del hist['Volume']
    history = hist.to_dict()
    print(type(history))
    print(history)
    quarterly = stock.quarterly_earnings.to_json()
    #print(type(quarterly))

    final = {}
    final['name'] = which
    final['quarterly'] = quarterly
    final['history'] = history

    result = json.dumps(final, indent=4)
    #print(result)

getStockData('MSFT')