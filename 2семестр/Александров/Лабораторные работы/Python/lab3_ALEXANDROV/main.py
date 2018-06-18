
class Decryptor():

    def __init__(self):
        self.arr = []
        self.arr_enc = []
        self.path_raw = ''
        self.path_enc = ''
        self.path_decrypt = ''
        self.arr_decrypt = []

    def makeBase_arr(self):
        for i in range(0,2048):
            temp = {'Char':0,'count':0}
            temp['Char'] = i
            self.arr.append(temp)
    def makeBase_arr_enc(self):
        for i in range(0,2048):
            temp = {'Char':0,'count':0}
            temp['Char'] = i
            self.arr_enc.append(temp)

    def makeAnalysis_raw(self):
        txt = open(self.path_raw, 'r', encoding='windows-1251')
        for i in txt:
            for j in i:
                for k in range(0,len(self.arr)):
                    if ord(j) == self.arr[k]['Char']:
                        self.arr[k]['count'] += 1
                        break
        txt.close()
    def makeAnalysis_Encrypted(self):
        txt = open(self.path_enc, 'r', encoding='windows=1251')
        for i in txt:
            for j in i:
                for k in range(0,len(self.arr_enc)):
                    if ord(j) == self.arr_enc[k]['Char']:
                        self.arr_enc[k]['count'] += 1
                        break
        txt.close()

    def Sorting_arr(self):
        n = 1
        ##Sorting for Statistic Chars
        while n<len(self.arr):
            for i in range(len(self.arr)-n):
                if self.arr[i]['count'] > self.arr[i+1]['count']:
                    self.arr[i], self.arr[i+1] = self.arr[i+1], self.arr[i]
            n += 1
    def Sorting_arr_enc(self):
        n = 1
        ##Sorting for Encrypting Chars
        while n < len(self.arr_enc):
            for i in range(len(self.arr_enc) - n):
                if self.arr_enc[i]['count'] > self.arr_enc[i + 1]['count']:
                    self.arr_enc[i], self.arr_enc[i + 1] = self.arr_enc[i + 1], self.arr_enc[i]
            n += 1

    def ifNotNull_arr(self):
        temp = []
        for i in self.arr:
            if i['count']!=0:
                temp.append(i)
        self.arr = temp
        self.arr_enc = temp
    def ifNotNull_arr_enc(self):
        temp = []
        for i in self.arr_enc:
            if i['count'] != 0:
                temp.append(i)

    def dictDecrypt(self):
        for i in range(0,len(self.arr_enc)):
            temp = {'char_enc':0,'char_raw':0}
            temp['char_enc'] = self.arr_enc[i]['Char']
            temp['char_raw'] = self.arr[i]['Char']
            self.arr_decrypt.append(temp)
    def makeDecrypt(self):
        txt_dec = open(self.path_decrypt, 'w+', encoding='windows-1251')
        txt_enc = open(self.path_enc,'r', encoding='windows-1251')
        a = ''
        for i in txt_enc:
            for j in i:
                for k in self.arr_decrypt:
                    if ord(j) == k['char_enc']:
                        a+=chr(k['char_raw'])
            a += '\n'
            txt_dec.write(a)
        txt_enc.close()
        txt_dec.close()


def main():
    Decrypt = Decryptor()
    #Decrypt.path_raw = input('Type directory of analysing text:\n')
    #Decrypt.path_enc = input('Type directory of encrypted text:\n')
    arr_raw = []
    arr_enc = []
    Decrypt.path_raw = 'book.txt'
    Decrypt.path_enc = 'encrypted.txt'
    Decrypt.path_decrypt = 'decrypted.txt'

    Decrypt.makeBase_arr()
    Decrypt.makeAnalysis_raw()
    Decrypt.ifNotNull_arr()
    Decrypt.Sorting_arr()
    arr_raw = Decrypt.arr
    Decrypt.arr = []
    print(arr_raw)

    Decrypt.makeBase_arr_enc()
    Decrypt.makeAnalysis_Encrypted()
    Decrypt.ifNotNull_arr_enc()
    Decrypt.Sorting_arr_enc()
    arr_enc = Decrypt.arr_enc
    Decrypt.arr_enc = []
    print(arr_enc)
    Decrypt.arr = arr_raw
    Decrypt.arr_enc = arr_enc
    Decrypt.dictDecrypt()
    print(Decrypt.arr_decrypt)
    Decrypt.makeDecrypt()


if __name__ == '__main__':
    main()