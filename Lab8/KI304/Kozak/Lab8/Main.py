import math
from math import radians

# Import file management functions from another module (assumed to be defined elsewhere)
from KI304.Kozak.Lab8.FileManager import *

# Initialize the angle variable
angle = 0.0

# Prompt the user for an angle input
print("Input angle")
try:
    # Try to read the angle input and convert it to a float
    angle = float(input())
except:
    # Handle invalid input types by printing an error and terminating the program
    print("Wrong value type")
    exit(-1)

# Convert the angle to radians
radX = math.radians(angle)

# Check if the angle satisfies conditions that may cause the value to reach infinity
if((angle % 0.5) != 0.0 and (radX / math.pi) % 0.0625 == 0):
    print("Value reach infinity at this angle")
    # Log the infinity condition to both text and binary files
    write_txt("Value reach infinity at this angle\n")
    write_bin("Value reach infinity at this angle\n")
    exit(-2)

# Calculate the result using a mathematical expression
result = math.sin(math.radians(angle)) * math.tan(8 * radians(angle))

# Log the result to both text and binary files
write_txt("Result is " + str(result) + "\n")
write_bin("Result is " + str(result) + "\n")

# Print and read the contents of the text file
print("\nTXT:")
read_txt()

# Print and read the contents of the binary file
print("\nBIN:")
read_bin()
