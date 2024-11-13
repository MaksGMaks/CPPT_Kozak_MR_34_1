import Phone
import datetime

"""
A subclass of the Phone class, representing a mobile phone with messaging capabilities.
"""
class MobilePhone(Phone.Phone):
    """
    Initializes the MobilePhone object by calling the parent class (Phone) constructor
    and setting up a message history.

    Parameters:
    number (str): The phone number of the mobile phone.
    volume (int): The initial volume level for the mobile phone.
    """
    def __init__(self, number, volume):
        # Initialize the parent Phone class
        super().__init__(number, volume)
        # Initialize an empty list to store messages
        self.__messages = list()

    """
    Sends a message to the receiver and logs the message details.

    Parameters:
    receiver (str): The recipient's phone number.
    message (str): The content of the message.
    """
    def send_message(self, receiver, message):
        # Append the message details (receiver, time, and message) to the message history
        self.__messages.append("You sent a message to " + str(receiver) + " at " + str(datetime.datetime.now())
                               + "\nMessage: " + message)

    """
    Prints the history of all messages sent from this mobile phone.
    """
    def print_message_history(self):
        # Iterate over each message in the message history and print it
        for message in self.__messages:
            print(message)
