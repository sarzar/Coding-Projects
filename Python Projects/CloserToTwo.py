print(" -------------")
print("|Closer To Two|")
print(" ------------- ")
print("This program demonstrates the process of adding to 0 to get\nto two but dividing the number being added each time. ")

totalAdd = 0
fractionAdd = 1

while totalAdd < 2:
    print("Your total: ", totalAdd)
    totalAdd = totalAdd + fractionAdd
    fractionAdd = fractionAdd/2

print("Will you ever get to two?")
