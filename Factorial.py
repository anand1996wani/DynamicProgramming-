'''

Factorial

Given an integer N, print the factorial of the N (mod 10^9 + 7).

Input:

First line contains one integer, T, number of test cases.
Each test case contains one integer, N.

Output:

For each test case you need to print the factorial of N (mod 10^9 + 7).

Constraints:

1 < T < 10^5
0 < N < 10^5

'''

def fact(n):
    if(array[n]!=-1):
        return array[n]
    else:
        array[n] = (n * fact(n-1))%((pow(10,9)) + 7)
        return array[n]


test = int(input())
array = [-1 for z in range(100001)]
array[0] = 1
array[1] = 1
for z in range(test):
    n = int(input())
    print(fact(n)%((pow(10,9)) + 7))
