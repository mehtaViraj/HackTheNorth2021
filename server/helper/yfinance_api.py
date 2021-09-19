import yfinance as yf
import json

def getStockData(which):
    stock = yf.Ticker(which)
    hist = stock.history(period="max")
    hist = hist[-30:]
    del hist['Volume']
    history = json.loads(hist.to_json())
    quarterly = json.loads(stock.quarterly_earnings.to_json())
    #print(type(quarterly))

    final = {}
    final['name'] = which
    final['quarterly'] = quarterly
    final['history'] = history

    if 'Revenue' not in final['quarterly'].keys():
        return 0

    #return json.dumps(final, indent=4)
    return final

#print(getStockData('MSFT'))