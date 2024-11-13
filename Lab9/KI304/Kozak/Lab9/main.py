import Phone
import MobilePhone

phone1 = Phone.Phone("0969867454", -1)
phone2 = Phone.Phone("0874635736", 15)

phone1.volume_down()
phone2.volume_up()

phone1.make_call("0874635736")
phone1.make_call("0824635999")
print("Phone1 call history:")
phone1.print_history()

mobile1 = MobilePhone.MobilePhone("0824635999", 5)
mobile2 = MobilePhone.MobilePhone("0986799836", 5)

mobile2.send_message("0824635999", "Hello, world!")
mobile2.send_message("0824635999", "How are u?")
print("\nMobilePhone2 message history:")
mobile2.print_message_history()
