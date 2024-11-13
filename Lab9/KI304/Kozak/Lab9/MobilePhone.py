import Phone
import datetime

class MobilePhone(Phone.Phone):
    def __init__(self, number, volume):
        super().__init__(number, volume)
        self.__messages = list()

    def send_message(self, receiver, message):
        self.__messages.append("You send message to " + str(receiver) + " at " + str(datetime.datetime.now())
                               + "\nMessage: " + message)

    def print_message_history(self):
        for message in self.__messages:
            print(message)
