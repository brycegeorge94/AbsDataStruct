.default: all

all: main

clean:
	rm -rf main *.o *.dSYM

main: BinarySearchTree.o Node.o main.cpp
	g++ -Wall -Werror -std=c++14 -O -o $@ $^

%.o: bst/%.cpp
	g++ -Wall -Werror -std=c++14 -O -c $^