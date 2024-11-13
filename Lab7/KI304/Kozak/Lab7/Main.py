import os

"""
Generates a matrix with a specified pattern and writes it to the given printer.

Parameters:
rows (int): Number of rows in the matrix.
sym (str): The symbol to be used in the matrix.
printer (file): The file object to write the matrix output.
"""
def gen_matrix(rows, sym, printer):
    matrix = []
    size = rows // 2
    column = list()

    # Create a column pattern with the specified symbol
    for i in range(size):
        column.append(sym)

    # Create the full matrix by copying the column pattern into each row
    for _ in range(rows):
        matrix.append(column.copy())

    # Print and write the matrix to the file
    print("Matrix:")
    printer.write("Matrix:\n")
    for i in range(rows):
        k = 0
        for j in range(rows):
            if j % 2 == 0:
                print(" ", end="")
                printer.write(" ")
            else:
                print(matrix[i][k], end="")
                printer.write(matrix[i][k])
                k += 1
        print()
        printer.write("\n")

# Start of program
# Initialize variables
rows = 0
symbol = ""
file_output = "Matrix.txt"

# Try to open the file for writing
try:
    fout = open(file_output, 'w')
except IOError:
    print("Program can't create file to output result. Program is terminated")
    exit(-4)

# Get the number of rows from the user
print("Input number of rows")
try:
    rows = int(input().strip())
except ValueError:
    print("Program expects one int argument. You input too many arguments or another datatype. Program is terminated")
    fout.write("Program expects one int argument. You input too many arguments or another datatype. Program is terminated\n")
    fout.close()
    exit(-1)

# Validate the number of rows
if rows <= 1:
    print(f"Cannot generate pattern in matrix with {rows} rows. Amount should be divisible by 6. Program is terminated")
    fout.write(f"Cannot generate pattern in matrix with {rows} rows. Amount should be divisible by 6. Program is terminated\n")
    fout.close()
    exit(-2)

# Get the symbol from the user
print("Input symbol")
symbol = input().strip()
if len(symbol) > 1:
    print("You input a word but program expects a char. Program is terminated")
    fout.write("You input a word but program expects a char. Program is terminated\n")
    fout.close()
    exit(-3)

# Generate and write the matrix
gen_matrix(rows, symbol, fout)
fout.close()
