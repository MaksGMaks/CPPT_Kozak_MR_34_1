import datetime

class Phone:
    def __init__(self, number, volume):
        if(volume > 10):
            self.__volume = 10
        elif (volume < 0):
            self.__volume = 0
        self.__number = number
        self.__history = list()

    def make_call(self, receiver_number):
        self.__history.append("You called to " + receiver_number + " at " + str(datetime.datetime.now()))

    def volume_up(self):
        if(self.__volume != 10):
            self.__volume += 1

    def volume_down(self):
        if (self.__volume != 10):
            self.__volume += 1

    def print_history(self):
        for call in self.__history:
            print(call)
