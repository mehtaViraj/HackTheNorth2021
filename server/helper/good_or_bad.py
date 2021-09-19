import pickle
import os
from sys import platform

f = open('good_words.dat', 'rb')
good_words = pickle.load(f)
f.close()

f = open('bad_words.dat', 'rb')
bad_words = pickle.load(f)
f.close()

def get_text(company):
    txt = ''
    for file in os.listdir(f"corpus_{company}"):
        with open(os.path.join(f"corpus_{company}", file), encoding="utf-8") as ofile:
            txt += ofile.read()

    return txt
def check(text):
    text = text.upper()
    text = list(text.split(' '))
    score = 0
    for i in text:
        if i in bad_words:
            score -= 1
        elif i in good_words:
            score += 3
    
    if score < 400:
        return("Unhappy")
    elif 400 <= score <= 900:
        return('Happy')
    elif score > 900:
        return('Very Happy!')
    else:
        return('Do not invest')

#print(check(get_text('AMZN')))