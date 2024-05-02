from town import Town


def main():
    t = Town("Dresden", 556780)
    print(str(t))
    print(repr(t))
    t.residents = -1
    print(t.name)
    print(t.residents)


if __name__ == "__main__":
    main()
