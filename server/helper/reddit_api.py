#! python3

"""personal use script = wHCu_ThCqGDSWzyRDzF0fA
security code = 2_wnaaHJYOvf4atHB_6i12X08hKBCA"""

import praw

reddit = praw.Reddit(client_id='wHCu_ThCqGDSWzyRDzF0fA', \
                     client_secret='2_wnaaHJYOvf4atHB_6i12X08hKBCA', \
                     user_agent='Stock Bot', \
                     username='the_real_mayo', \
                     password='Sunf10wer')

subreddit = reddit.subreddit('wallstreetbets').search("google")
#sussy = subreddit.top(limit = 10)
temp = 0
for i in subreddit:
    if len(i.selftext) == 0:
        continue
    temp +=1

    f = open(f"./server/helper/corpus/{temp}_reddit.txt", 'w', encoding='utf-8')
    f.write(i.selftext)
    f.close()
