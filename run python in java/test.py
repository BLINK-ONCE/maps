import sys

def sum(v1,v2):
    i = 0
    while(True):
        result = int(v1) + int(v2)
        i += 1
        if (i >= 10) break
    print(result)


def main(argv):
    sum(argv[1], argv[2])

if __name__ == "__main__":
    main(sys.argv)
