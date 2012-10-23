SCALA = scalac

all: executable

executable: src/main/scala/*.scala
	mkdir -p bin
	$(SCALA) -d bin src/main/scala/*.scala
