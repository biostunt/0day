import math

def addcord(line):
    k = line
    a = ''
    for i in range(0, len(k)):
        if (k[i] == ' ') or (k[i] == '\n'):
            s.append(a)
            a = ''
        a = a + k[i]
def FindDistance(a1,a2,b1,b2):
    Dist = math.sqrt(math.pow(b1-a1,2)+ pow(b2-a2,2))
    txtout.write('Distance between points: {}\n'.format(str(Dist)))
def Polarcord(x, y, t):
    Polar = math.sqrt(x*x+y*y)
    txtout.write('Полярные координаты точки {} : {}\n'.format(t, str(Polar)))
def Polarangle(x,y, t):
    if (x == 0):
        txtout.write('Полярный угол точки {} равен нулю\n'.format(t))
        return
    angle = ((y/x)*180)/math.pi
    txtout.write('Полярный угол точки {} : {}\n'.format(t, str(angle)))


txt = open('input.txt','r')
txtout = open('output.txt','w+')
s = []


for line in txt:
    addcord(line)
A = {'x': int(s[0]), 'y': int(s[1])}
B = {'x': int(s[2]), 'y': int(s[3])}

FindDistance(A['x'],A['y'],B['x'],B['y'])
Polarcord(A['x'],A['y'],'A')
Polarcord(B['x'],B['y'],'B')
Polarangle(A['x'],A['y'],'A')
Polarangle(B['x'],B['y'],'B')
