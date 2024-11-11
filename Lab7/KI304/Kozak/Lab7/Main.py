import os


def gen_matrix(rows, sym, printer):
    matrix = []
    size = rows // 2
    column = list()
    for i in range(0, size):
        column.append(sym)


    for _ in range(rows):
        matrix.append(column.copy())

    print("Matrix:")
    printer.write("Matrix:\n")
    for i in range(0, rows):
        k = 0
        for j in range(0, rows):
            if j % 2 == 0:
                print(" ", end="")
                printer.write(" ")
            else:
                print(matrix[i][k], end="")
                printer.write(matrix[i][k])
                k += 1
        print()
        printer.write("\n")

rows = 0
symbol = ""

file_output = "Matrix.txt"

try:
    fout = open(file_output, 'w')
except IOError:
    print("Program can't create file to output result. Program is terminated")
    exit(-4)

print("Input number of rows")
try:
    rows = int(input().strip())
except ValueError:
    print(
        "Program expects one int argument. You input too many arguments or another datatype. Program is terminated")
    fout.write(
        "Program expects one int argument. You input too many arguments or another datatype. Program is terminated\n")
    fout.close()
    exit(-1)

if rows <= 1:
    print(
        f"Cannot generate pattern in matrix with {rows} rows. Amount should be divisible by 6. Program is terminated")
    fout.write(
        f"Cannot generate pattern in matrix with {rows} rows. Amount should be divisible by 6. Program is terminated\n")
    fout.close()
    exit(-2)

print("Input symbol")
symbol = input().strip()
if len(symbol) > 1:
    print("You input a word but program expects a char. Program is terminated")
    fout.write("You input a word but program expects a char. Program is terminated\n")
    fout.close()
    exit(-3)

gen_matrix(rows, symbol, fout)
fout.close()