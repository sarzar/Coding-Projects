print(" -------- ")
print("|Election|")
print(" -------- ")
print("This program takes in votes from the user and displays the election winner")
votes = []
i = 1
bidenCounter = 0
trumpCounter = 0
while i != 0:
    vote = input("Are you voting for trump or biden: ")
    if vote == "biden" or vote == "trump":
        votes.append(vote)
        i = int(input("Press 1 to vote again or Press 0 to tally votes: "))
    else:
        print("Invalid Vote! The election is rigged!")
        exit(0)
for n in votes:
    if(n  == "biden"):
        bidenCounter += 1
    if(n == "trump"):
        trumpCounter += 1

if trumpCounter > bidenCounter:
    print("Donald Trump is your new president!")

elif trumpCounter == bidenCounter:
    print("Whoops, Looks like Biden and Trump will have to share office....")
else:
    print("Joe Biden is your new president!")


