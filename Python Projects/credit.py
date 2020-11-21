import re

#Get credit card number from user

number = input("Number: ")


#Error Checking
if len(number) < 13 or len(number) > 17:
    print("INVALID")


i = len(number) - 2
checker = number
counter = 0
p = 0
while True:
    p = int(checker[i])*2
    if(p > 9):
        r = str(p)
        counter += int(r[0])
        counter += int(r[1])
    else:
        counter += p
    i-=2
    p = 0
    if i < 0:
        break


j = len(number) - 1
checkernext = number
counternext = 0
while True:
   counternext += int(checker[j])
   j-=2
   if j < 0:
       break
  
final = counter + counternext





if final%10 == 0:
    
    
   
    if len(number) == 15:
        
        if re.search("^37", number) or re.search("^34", number) :
            print("AMEX")
        
    elif len(number) == 13 or len(number) == 16:
        
    
        if re.search("^4", number):
            print("VISA")
        elif re.search("^5[1,2,3,4,5]", number):
            print("MASTERCARD")
            