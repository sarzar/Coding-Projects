from cs50 import get_int

#Gets input from user on loop until correct input is given
while True:
    h = get_int("Height: ")
    if h >= 1 and h <= 8:
        break;
        
#Creates half-pyramids
i = 0
for i in range(h):
    
#Spaces
    j=0
    for j in range(h-i):
        print(" ", end = "")
        j+=1
    
#Hashes(L)
    d = 0
    while True:
        print("#", end = "")
        d+=1
        if d > i:
            break
        
#Space in between
    print("  ", end = "")
    
#Hashes(R)
    d = 0
    while True:
        print("#", end = "")
        d+=1
        if d > i:
            break
    i+=1
    print("")