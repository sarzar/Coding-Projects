import math

print("Triangles")
print("---------")
print("Three number represent the side lengths of a triangle when the sum \nof any two sides is greater than the third side")
print("Right Triangles")
print("---------------")
print("A right-angled triangle has the property that when the values of the \nlengths of the sides are squared, the sum of the two smaller values is equal to the largest side.")
print("This program has the user enter three lengths of sides and determines \nwhether the figure is a triangle or not. If a triangle can be formed, it will determine if it is a right triangle.")



sideOne = float(input("Please enter a value for side 1: "))
sideTwo = float(input("Please enter a value for side 2: "))
sideThree = float(input("Please enter a value for side 3: "))


if sideOne <= 0 or sideTwo <= 0 or sideThree <= 0:
    print("Invalid input! Please try again with values bigger than 0")

elif (sideOne + sideTwo) > sideThree and (sideOne + sideThree) > sideTwo and (sideThree + sideTwo) > sideOne:

    if math.pow(sideOne, 2) + math.pow(sideTwo, 2) == math.pow(sideThree, 2):
        print("It is a right-angle triangle")

    elif math.pow(sideThree, 2) + math.pow(sideTwo, 2) == math.pow(sideOne, 2):
        print("It is a right-angle triangle")

    elif math.pow(sideOne, 2) + math.pow(sideThree, 2) == math.pow(sideTwo, 2):
        print("It is a right-angle triangle")

    else:
        print("Its a triangle")

else:
    print("It is not a triangle")
    

