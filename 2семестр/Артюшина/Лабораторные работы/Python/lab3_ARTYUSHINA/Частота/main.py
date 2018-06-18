def checkChar(char):
    for i in charContainer:
        if (i['char'] == ord(char)):
            return 1
    return 0
def addChar(char):
    temp = {"char":0,"count":0}
    temp["char"] = ord(char)
    temp["count"] += 1
    charContainer.append(temp)
def appendCount(char):
    for i in charContainer:
        if i["char"] == ord(char):
            i["count"] += 1
def outChars(): 
    out = open("Частота/out.txt", "w+")
    out.write("Количество букв в тексте: {}\n".format(counter))
    for char in charContainer:
        line = "Буква {} == {} Частота {}%\n".format(chr(char["char"]),char["count"],(char["count"] / counter) * 100)
        out.write(line)
def sortingChar(length):
    n = 1
    while n < length:
        for i in range(length-n):
            if charContainer[i]["count"] < charContainer[i + 1]["count"]:
                charContainer[i],charContainer[i + 1] = charContainer[i + 1],charContainer[i]
        n += 1

charContainer = []
text = open("Частота/text.txt","r")
counter = 0

for line in text:
    for char in line:
        counter += 1
        state = checkChar(char)
        if (state == 0):
            addChar(char)
        else:
            appendCount(char)

sortingChar(len(charContainer))
outChars()









