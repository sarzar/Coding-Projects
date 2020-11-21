


text = input("Text: ")


lettercounter = 0.0
wordcounter = 1.0
sentencecounter = 0.0

for c in text:
    if c.isalpha():
        lettercounter += 1
    if c == ' ':
        wordcounter += 1
    if c == '.' or c == '!' or c == '?':
        sentencecounter += 1
        

l = (lettercounter/wordcounter)*100
s = (sentencecounter/wordcounter)*100
index = 0.0588 * l - 0.296 * s - 15.8

if index < 1:
    print("Before Grade 1")
     
elif index >= 16:
     
    print("Grade 16+")
     
else:
     
    print("Grade " +str(round(index)))