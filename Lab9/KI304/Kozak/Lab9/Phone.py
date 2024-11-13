import datetime


class Phone:
    """
    Initializes the Phone object with a number and volume.

    Parameters:
    number (str): The phone number of the user.
    volume (int): The initial volume level (should be between 0 and 10).
    """
    def __init__(self, number, volume):
        # Ensures the volume is within the valid range (0-10)
        if volume > 10:
            self.__volume = 10
        elif volume < 0:
            self.__volume = 0
        else:
            self.__volume = volume  # If volume is within the range, use the provided value

        self.__number = number  # Store the phone number
        self.__history = list()  # Initialize an empty call history list

    """
    Makes a call to the given receiver number and logs the call time.

    Parameters:
    receiver_number (str): The phone number of the receiver.
    """
    def make_call(self, receiver_number):
        # Append the call details to the history list
        self.__history.append("You called to " + receiver_number + " at " + str(datetime.datetime.now()))

    """
    Increases the volume by 1, ensuring it does not exceed 10.
    """
    def volume_up(self):
        if self.__volume < 10:  # Ensure volume doesn't exceed 10
            self.__volume += 1
            print("Current volume: " + str(self.__volume))
        else:
            print("Volume is already maxed out")

    """
    Decreases the volume by 1, ensuring it does not go below 0.
    """
    def volume_down(self):
        if self.__volume > 0:  # Ensure volume doesn't go below 0
            self.__volume -= 1
            print("Current volume: " + str(self.__volume))
        else:
            print("Volume is already downed to 0")

    """
    Prints the history of calls made from this phone.
    """
    def print_history(self):
        # Iterate over each call in the history and print it
        for call in self.__history:
            print(call)
