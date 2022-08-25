build:
	mvn clean dependency:copy-dependencies package -l ./picoli-log.log

run:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar --help | bat -l help -p

run-add:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar add --help | bat -l help -p

run-list:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar list --help | bat -l help -p

run-update:
	java -jar target/todo-cli-1.0-SNAPSHOT.jar update --help | bat -l help -p


all: build run
