class Hockey:

    def __init__(self, name, number, position):
        self.name = name
        self.number = number
        self.position = position

    def get_name(self):
        return self.name

    def get_number(self):
        return self.number

    def get_position(self):
        return self.position

    def set_name(self, name):
        self.name = name

    def set_position(self, position):
        self.position = position

    def set_number(self, number):
        self.number = number

    def __str__(self):
        return "Number %i %s plays as %s." % (self.number, self.name, self.position)

player1 = Hockey("Patrik", 16, "Centre")
print(player1.get_name())
print(player1.get_number())
print(player1.get_position())
print(player1)