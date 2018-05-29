'''

You are working at the cash counter at a fun-fair, and you have different types of coins available to you in infinite quantities. The value of each coin is already given. Can you determine the number of ways of making change for a particular number of units using the given types of coins?

For example, if you have 4 types of coins, and the value of each type is given as 8,3,1,2 respectively, you can make change for 3 units in three ways: {1,1,1},{1,2} and {3} .

Complete the function getWays that takes the number of coin types and the value of each coin type as input, and return the number of ways to make change for n units using any number of coins.

Input Format

The first line contains two space-separated integers describing the respective values of  and , where: 
n is the number of units 
m is the number of coin types 
The second line contains m space-separated integers describing the respective values of each coin type : c0,c1,....,cm-1 (the list of distinct coins available in infinite amounts).

Sample Input 0

4 3
1 2 3

Sample Output 0

4
-------------------------
Sample Input 1

10 4
2 5 3 6

Sample Output 1

5

'''

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the getWays function below.
def getWays(n, c):
    table = [[0 for j in range(n+1)] for i in range(len(c))]
    c.sort()
    for i in range(1,n+1):
        if i%c[0]==0:
            table[0][i] = 1
    
    for j in range(len(c)):
        table[j][0] = 1
    
    for i in range(1,len(c)):
        for j in range(1,n+1):
            if(j >= c[i]):
                #table[i][j] = table[i-1][j] + max(table[i-1][j - c[i]],table[i][j - c[i]])
                table[i][j] = table[i-1][j] + table[i][j - c[i]]
            else:
                table[i][j] = table[i-1][j]
    
    return table[len(c) - 1][n]
    
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    c = list(map(int, input().rstrip().split()))

    # Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    ways = getWays(n, c)
    #ways = 4
    fptr.write(str(ways))
    fptr.close()

