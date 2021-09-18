import yfinance as yf
import json
which = input("Which stock: ")
stock = yf.Ticker(which)
details = stock.info
hist = stock.history(period="max")
hist = hist[-30:]
del hist['Volume']
final = hist.to_json()
print(final)
quarterly = stock.quarterly_earnings
