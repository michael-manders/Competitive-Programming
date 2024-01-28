import sys
sys.setrecursionlimit(15000000)



# def fib(n):
#     if n == 1: return 1
#     if n == 2: return 1

#     return fib(n - 1) + fib(n - 2)


# for i in range(1, 1000):
#     print(fib(i))

fibsquence=  [1, 1]

n = 100

for i in range(2, n):
    fibsquence.append(fibsquence[-1] + fibsquence[-2])

print(fibsquence)