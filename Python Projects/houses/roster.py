#IMPORTS
import sys

from cs50 import SQL
db = SQL("sqlite:///students.db")

if len(sys.argv) != 2:
    print("ERROR!")
    sys.exit(1)
    
list[] = db.execute("SELECT * FROM students WHERE house = (?)", sys.argv[1])


j = 0

for i in list:
    
    print(list[j][2]) 
    print(list[j][4])
    print(list[j][6])
    print(list[j][8]) 
    print(list[j][10])
    print("/n")
    j+=1
        