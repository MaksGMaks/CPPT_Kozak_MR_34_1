import struct


"""
Clears the content of the text file "result.txt" by opening it in write mode 
and closing it immediately.
"""
def clear_txt():
    fname = "result.txt"
    try:
        # Open the file in text write mode ('t+w') with UTF-8 encoding
        file = open(fname, "t+w", encoding="utf-8")
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()


"""
Clears the content of the binary file "result.bin" by opening it in write mode
and closing it immediately.
"""
def clear_bin():
    fname = "result.bin"
    try:
        # Open the file in binary write mode ('b+w')
        file = open(fname, "b+w")
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()


"""
Appends a message to the text file "result.txt".

Parameters:
message (str): The message to be written to the text file.
"""
def write_txt(message):
    fname = "result.txt"
    try:
        # Open the file in append mode ('t+a') with UTF-8 encoding
        file = open(fname, "t+a", encoding="utf-8")
        file.write(message)  # Write the message to the file
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()


"""
Appends a message to the binary file "result.bin". The message is encoded in UTF-8.

Parameters:
message (str): The message to be written to the binary file.
"""
def write_bin(message):
    fname = "result.bin"
    try:
        # Open the file in binary append mode ('b+a')
        with open(fname, 'b+a') as file:
            file.write(message.encode('utf-8'))  # Encode and write the message
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)


"""
Reads and prints the contents of the text file "result.txt".
"""
def read_txt():
    fname = "result.txt"
    try:
        # Open the file in text read mode ('t+r') with UTF-8 encoding
        file = open(fname, "t+r", encoding="utf-8")
        for line in file:
            print(line, end='')  # Print each line of the file
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()


"""
Reads and prints the contents of the binary file "result.bin", decoding the data as UTF-8.
"""
def read_bin():
    fname = "result.bin"
    try:
        # Open the file in binary read mode ('b+r')
        with open(fname, 'b+r') as file:
            for line in file:
                print(line.decode('utf-8'), end='')  # Decode each binary line and print it
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
