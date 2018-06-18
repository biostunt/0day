
text = open("text.txt","r")
out = open("out.txt", "w+")
for line in text:
    input = line
    break
take1 = 0
take2 = 0
for char in input:
    if (char == '('):
        take1 += 1
    if (char == ')'):
        take2 +=1
out.write(" кол-во открывающихся скобок = {} \n кол-во закрывающехся скобок = {}".format(take1, take2))
