def findchar(a):
	k = ord(a)
	for i in mainarr:
		if (i['char']==k):
			i['count'] = i['count'] + 1
			break
text = open('../encrypted.txt','r',encoding='windows-1251')
out = open('../out_encoded.txt','w+')
words = 0
letters = 0
mainarr= []
for i in range(0,2048):
	temp = {'char':0,'count':0}
	temp['char'] = i
	mainarr.append(temp)
for i in text:
	words += len(i.split())
	for j in i:
		letters +=1
		findchar(j)
k = 'count of words = '+str(words)+'\n'
out.write(k)
k = 'count of letters = '+str(letters)+'\n'
out.write(k)
n = 1
while n<len(mainarr):
	for i in range(len(mainarr)-n):
		if mainarr[i]['count'] < mainarr[i]['count']:
			mainarr[i], mainarr[i+1] = mainarr[i+1], mainarr[i]
	n += 1
for i in mainarr:
	if (i['count']!=0):
		k = '[' + chr(i['char'])+']'+' = '+ str(i['count'])+'------------'+str(i['count']/letters)+'\n'
		out.write(k)

