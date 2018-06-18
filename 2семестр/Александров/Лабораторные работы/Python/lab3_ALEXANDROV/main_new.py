def createArr(a):
    for i in range(0,2048):
        temp = {'char': 0, 'count': 0}
        temp['char'] = i
        a.append(temp)
    return a
def Analysing(ARR, ENCODING, TXT):
    inp = open(TXT, 'r', encoding=ENCODING)
    for i in inp:
        for j in i:
            for k in ARR:
                if ord(j) == k['char']:
                    k['count']+=1
                    break
    return ARR
def ifNotNull(ARR):
    temp = []
    for i in ARR:
        if (i['count'] != 0) :
            temp.append(i)
    return temp
def Sorting(ARR):
    n = 1
    while n < len(ARR):
        for i in range(len(ARR) - n):
            if ARR[i]['count'] < ARR[i + 1]['count']:
                ARR[i], ARR[i + 1] = ARR[i + 1], ARR[i]
        n += 1
    return ARR

def dictDecrypt():
    for i in range(len(arr_enc)):
        temp = {'char_raw':0,'char_enc':0}
        temp['char_raw'] = arr_raw[i]['char']
        temp['char_enc'] = arr_enc[i]['char']
        arr_dec.append(temp)
def decryptText():
    txt_dec = open(TXT_DEC,'w+',encoding=ENCODING)
    txt_enc = open(TXT_ENC,'r',encoding=ENCODING)
    for i in txt_enc:
        a = ''
        for j in i:
            for k in arr_dec:
                if ord(j) == k['char_enc']:
                    a += chr(k['char_raw'])
        txt_dec.write(a+'\n')
def vikiniornot(a):
    for i in trash:
        if a == ord(i):
            return 1
    return 0
def VikinutMYSOR(a):
    temp = []
    for i in arr_raw:
        if vikiniornot(i['char']) == 0:
            temp.append(i)
    return temp

ENCODING = 'windows-1251'
TXT_RAW = 'book.txt'
TXT_ENC = 'encrypted.txt'
TXT_DEC = 'decrypted.txt'
arr_raw = []
arr_enc = []
arr_dec = []

arr_raw = createArr(arr_raw)
arr_enc = createArr(arr_enc)

arr_raw = Analysing(arr_raw,ENCODING,TXT_RAW)
arr_enc = Analysing(arr_enc,ENCODING,TXT_ENC)

#print(arr_raw)
#print(arr_enc)

arr_raw = ifNotNull(arr_raw)
arr_enc = ifNotNull(arr_enc)

#print(arr_raw)
#print(arr_enc)

arr_raw = Sorting(arr_raw)
arr_enc = Sorting(arr_enc)

#print(arr_raw)
#print(arr_enc)

trash ="1234567890qwertyuiopasdfghjklzxcvbnm,./!@#$%^&*()-_=+?><:;"
arr_raw = VikinutMYSOR(trash)
print(arr_raw)
print(arr_enc)
dictDecrypt()

print(arr_dec)

decryptText()