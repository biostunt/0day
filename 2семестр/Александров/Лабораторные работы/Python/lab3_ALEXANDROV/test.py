import random
a = []
for i in range(0,1000):
    a.append(random.randint(0,1000))

n = 1
while n<len(a):
    for i in range(len(a) - n):
        if a[i] < a[i+1]:
            a[i], a[i+1] = a[i+1], a[i]
    n += 1
print(a)

print(ord('о'))



import math
print(math.factorial(33))
for i in range(44,100):
    print('i = ',i,' chr = ',chr(i))

от 44 до 64