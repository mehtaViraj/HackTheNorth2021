import pickle
f = open('good_words.dat', 'rb')
good_words = pickle.load(f)
f.close()

f = open('bad_words.dat', 'rb')
bad_words = pickle.load(f)
f.close()

def check(text):
    text = text.upper()
    text = list(text.split(' '))
    score = 0
    for i in text:
        if i in bad_words:
            score -= 1
        elif i in good_words:
            score += 3
    return score

print(check())

