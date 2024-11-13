import Phone
import MobilePhone

# Create Phone objects with invalid volume values for testing
phone1 = Phone.Phone("0969867454", -1)  # Volume should be set to 0 due to the constructor logic
phone2 = Phone.Phone("0874635736", 15)  # Volume should be set to 10 due to the constructor logic

# Adjust the volume of the phones
phone1.volume_down()  # Decrease volume of phone1 (volume will stay at 0)
phone2.volume_up()    # Increase volume of phone2 (volume will be set to 10)

# Make calls with phone1
phone1.make_call("0874635736")
phone1.make_call("0824635999")

# Print phone1's call history
print("Phone1 call history:")
phone1.print_history()

# Create MobilePhone objects
mobile1 = MobilePhone.MobilePhone("0824635999", 5)  # Initial volume is 5
mobile2 = MobilePhone.MobilePhone("0986799836", 5)  # Initial volume is 5

# Send messages with mobile2
mobile2.send_message("0824635999", "Hello, world!")
mobile2.send_message("0824635999", "How are u?")

# Print mobile2's message history
print("\nMobilePhone2 message history:")
mobile2.print_message_history()
