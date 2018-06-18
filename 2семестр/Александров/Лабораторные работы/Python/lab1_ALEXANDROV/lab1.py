import math

def InputtoList(line):
    a = ''
    addlist = []
    addlist.clear()
    for i in range(0,len(line)):
        if (line[i]==' '):
            addlist.append(a)
            a = ''
        a += line[i]
    mainlist.append(addlist)
    return 0

def CheckSumofMarks():
    for i in range(0,len(mainlist)):
        addlist = mainlist[i]
        dict = {'Name':'','Num':0}
        dict['Name'] = addlist[0]
        dict['Num'] = len(addlist)-1
        sumlist.append(dict)

def CheckMediumValue():
    for i in range(0,len(mainlist)):
        addlist = mainlist[i]
        dict = {'Name':'','Medium':0}
        dict['Name'] = addlist[0]
        p = 0
        for i in range(1,len(addlist)):
            k = int(addlist[i])
            p += k
        p = p/(len(addlist)-1)
        dict['Medium'] = p
        mediumlist.append(dict)

def CheckDispersionValue():
    for i in range(0, len(mainlist)):
        addlist = mainlist[i]
        dict = {'Name': '', 'Dispersion': 0}
        dict['Name'] = addlist[0]
        p = 0
        n = len(addlist)
        for j in range(1, len(addlist)):
            p += pow(((int(addlist[j])-mediumlist[i]['Medium'])),2)
        disp = p/n
        dict['Dispersion'] = disp
        Dispersionlist.append(dict)

   


def Sort1():
    for i in range(0,len(sumlist)):
        for j in range(i+1,len(sumlist)):
            if sumlist[j]['Num'] > sumlist[i]['Num']:
                tt = mainlist[j]
                mainlist[j] = mainlist[i]
                mainlist[i] = tt


def Sort2():
    for i in range(0,len(mediumlist)):
        for j in range(i+1,len(mediumlist)):
            if mediumlist[j]['Medium'] > mediumlist[i]['Medium']:
                tt = mainlist[j]
                mainlist[j] = mainlist[i]
                mainlist[i] = tt
                

def Sort3():
    for i in range(0,len(Dispersionlist)):
        for j in range(i+1,len(Dispersionlist)):
            if Dispersionlist[j]['Dispersion'] < Dispersionlist[i]['Dispersion']:
                tt = mainlist[j]
                mainlist[j] = mainlist[i]
                mainlist[i] = tt

def FindName(x,name):
    if (x==0):
        for i in sumlist:
            if (i['Name']==name):
                return i['Num']
    if (x==1):
        for i in mediumlist:
            if (i['Name']==name):
                return i['Medium']
    if (x==2):
        for i in Dispersionlist:
            if (i['Name']==name):
                return i['Dispersion']

txt = open('input.txt','r')
txtout = open('output.txt','w+')

## main lists with content
mainlist = []
sumlist = []
mediumlist = []
Dispersionlist = []
CheckB
for line in txt:
    InputtoList(line)
print(mainlist)

## Medium Value
CheckMediumValue()
Sort2()
print(mediumlist)



## Dispersion Value
CheckDispersionValue()
Sort3()
print(Dispersionlist)

## Marks Value
CheckSumofMarks()
Sort1()
print(sumlist)

for i in range(0,len(mainlist)):
    p = mainlist[i][0]
    a = ''
    for j in range(0,len(mainlist[i])):
        a = a + mainlist[i][j]
    a = a + '| количество оценок: {x}, средняя оценка: {y}, Дисперсия: {z}\n'.format(x=FindName(0,p),y=FindName(1,p),z=FindName(2,p))
    txtout.write(a)
