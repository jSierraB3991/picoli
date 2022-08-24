build:
	mvn clean dependency:copy-dependencies package -l ./picoli-log.log

run:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar --help

run-add:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar add --help

run-list:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar list --help

all: build run
