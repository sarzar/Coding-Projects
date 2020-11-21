#IMPORTS
import sys
import csv
from cs50 import SQL
db = SQL("sqlite:///students.db")


#ERRORCHECKING
if len(sys.argv) != 2:
   print("ERROR! PLEASE INPUT CORRECT LENGTH")
   sys.exit(1)


#OPENING CSV FILE & WRITING TO SQL DATABASE
with open(sys.argv[1], newline = '') as csvfile:
    info = csv.reader(csvfile, delimiter = ',')
    for row in info:
        
       name = row[0] 
       house = row[1]
       birth = row[2]
       
       names = name.split()
       if len(names) == 2:
          db.execute("INSERT INTO students (first,middle,last,house,birth) VALUES(?,?,?,?,?)", names[0], "", names[1], house, birth )
          
       elif len(names) == 3:
           db.execute("INSERT INTO students (first,middle,last,house,birth) VALUES(?,?,?,?,?)", names[0],names[1], names[2], house, birth )
           
       
      
    

