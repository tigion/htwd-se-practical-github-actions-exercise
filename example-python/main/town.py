class Town:

    def __init__(self, name, residents):
        self.name = name
        self.residents = residents

    def toString(self):
        return "Town [name=" + self.name + ", residents=" + str(self.residents) + "]"

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, value):
        if value and not value.isspace():
            self.__name = value
        else:
            raise ValueError("name cannot be null, empty or contain only white spaces")

    @property
    def residents(self):
        return self.__residents

    @residents.setter
    def residents(self, value):
        self.__residents = value
