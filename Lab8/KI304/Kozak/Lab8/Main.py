import math
from math import radians
from traceback import print_exception

from KI304.Kozak.Lab8.FileManager import *

angle = 0.0
print("Input angle")
try:
    angle = float(input())
except:
    print("Wrong value type")
    exit(-1)

radX = math.radians(angle)
if((angle % 0.5) != 0.0 and (radX / math.pi) % 0.0625 == 0):
    print("Value reach infinity at this angle")
    write_txt("Value reach infinity at this angle\n")
    write_bin("Value reach infinity at this angle\n")
    exit(-2)

result = math.sin(math.radians(angle)) * math.tan(8 * radians(angle))
write_txt("Result is " + str(result) + "\n")
write_bin("Result is " + str(result) + "\n")

print("\nTXT:")
read_txt()
print("\nBIN:")
read_bin()