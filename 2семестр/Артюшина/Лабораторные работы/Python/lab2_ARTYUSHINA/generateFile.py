out = open('input.txt','w+')
import random

k = random.randint(0,100)
line = str(k)+'\n'
out.write(line)

for i in range(0,k):
	x = random.randint(0,50)-25
	y = random.randint(0,50)-25
	line = str(x) + ' ' + str(y) + '\n'
	out.write(line)

