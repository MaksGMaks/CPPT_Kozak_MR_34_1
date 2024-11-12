import struct


def clear_txt():
    fname = "result.txt"
    try:
        file = open(fname, "t+w", encoding="utf-8")
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()

def clear_bin():
    fname = "result.bin"
    try:
        file = open(fname, "b+w")
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()

def write_txt(message):
    fname = "result.txt"
    try:
        file = open(fname, "t+a", encoding="utf-8")
        file.write(message)
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()

def write_bin(message):
    fname = "result.bin"
    try:
        with open(fname, 'b+a') as file:
            file.write(message.encode('utf-8'))
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)

def read_txt():
    fname = "result.txt"
    try:
        file = open(fname, "t+r", encoding="utf-8")
        for line in file:
            print(line, end='')
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)
    finally:
        file.close()

def read_bin():
    fname = "result.bin"
    try:
        with open(fname, 'b+r') as file:
            for line in file:
                print(line.decode('utf-8'), end='')
    except OSError:
        print(f"Error while opening file {fname}. Program terminated")
        exit(-1)