# RateLimiter: Execute query when number of queries per minute is lower than MAX_RATE_PER_MIN
#
# @author Prasanna Pavani
# 12/5/2018

from datetime import datetime as dt
import time

MAX_RATE_PER_MIN = 10
hash = {}

# returns 1 if underlimit, else 0
def isUnderLimit(userId):
    return (1 if updateHash(userId) <= MAX_RATE_PER_MIN else 0)

#returns counts for userid in last 60 seconds
def updateHash(userId):
    if not userId in hash:
        hash[userId] = [1,dt.now()]
        return 1
    else:
        list = hash[userId]
        tnow = dt.now()

        if (dt.now() - list[1]).seconds <= 60:
            list[0] += 1
        else:
            list[0] = 1

        list[1] = tnow
        hash[userId] = list
        return list[0]

# test case
for i in range(40):
    print(1,isUnderLimit(1))
    if i%2 == 0:
        print(2,isUnderLimit(2))
