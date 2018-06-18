input = open('input.txt','r')
output = open ('output.txt','w+',)
import math
def StrToInt(line):
	if line == countline:
		return
	temp = {'x':0,'y':0}
	temparr = []
	a = ''
	for i in line:
		if (i==' ') or (i=='\n'):
			temparr.append(a)
			a = ''
		else:
			a = a + i
	temp['x'] = int(temparr[0])
	temp['y'] = int(temparr[1])
	mainarr.append(temp)

mainarr = []
Zmax = 0
ArgZx = 0
ArgZy = 0
Zmaxx = 0
Zmaxy = 0
Zsumx = 0
Zsumy = 0
countline = ''
ArgZmax = 0
p = 0
op = 0

for i in input:
	countline = i
	break

for i in input:
	StrToInt(i)
for i in range (0,len(mainarr)):
	p = math.sqrt((mainarr[i]['x']*mainarr[i]['x'])+
				  (mainarr[i]['y']*mainarr[i]['y']))
	fi = math.atan2(mainarr[i]['y'],mainarr[i]['x'])
	if (Zmax < p):
		Zmax = p
		Zmaxx = mainarr[i]['x']
		Zmaxy = mainarr[i]['y']
	Zsumx += mainarr[i]['x']
	Zsumy += mainarr[i]['y']
	if (ArgZmax < fi):
		ArgZmax = fi
		ArgZx = mainarr[i]['x']
		ArgZy = mainarr[i]['y']

## 1st - question
line = '1) Z с наибольшим модулем - ' + str(Zmax) + ' координаты:  x:{} y:{}\n'.format(str(Zmaxx),str(Zmaxy))
output.write(line)
## 2st - question
line = '2) Сумма всех Z = ({}) + i*({}), где i= sqrt(-1)\n '.format(str(ArgZx),str(ArgZy))
output.write(line)

## 3st - question
Xtemp = mainarr[0]['x']
Ytemp = mainarr[0]['y']
for i in range (1,len(mainarr)):
	Mainpart = (Xtemp*mainarr[i]['x'] - Ytemp*mainarr[i]['y'])
	Mnimpart = (Xtemp*mainarr[i]['y'] + Ytemp*mainarr[i]['x'])
	Xtemp = Mainpart
	Ytemp = Mnimpart

line = '3)Произведение всех Z = {} + i({})\n'.format(Xtemp, Ytemp)
output.write(line)

## 4st - question
line = '4) Наибольший аргумент Z - {} с координатами x:{} y:{}\n'.format(str(ArgZmax),str(ArgZx),str(ArgZy))
output.write(line)








