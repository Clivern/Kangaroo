GRADLEW           ?= ./gradlew


help: Makefile
	@echo
	@echo " Choose a command run in Alligator:"
	@echo
	@sed -n 's/^##//p' $< | column -t -s ':' |  sed -e 's/^/ /'
	@echo


## assemble: Gradle assemble code task
assemble:
	@echo ">> ============= Gradle assemble code task ============= <<"
	$(GRADLEW) assemble --info


## update: Gradle update pom file
update:
	@echo ">> ============= Gradle update pom file ============= <<"
	$(GRADLEW) updatePom


## check: Gradle check code task
check:
	@echo ">> ============= Gradle check code task ============= <<"
	$(GRADLEW) check --info


## build: Gradle build jar task
build:
	@echo ">> ============= Gradle build jar task ============= <<"
	$(GRADLEW) build --info


## upload: Gradle upload archives task
upload:
	@echo ">> ============= Gradle upload archives task ============= <<"
	$(GRADLEW) -b maven-push.gradle uploadArchives


## format: Gradle format code task
format:
	@echo ">> ============= Gradle format code task ============= <<"
	$(GRADLEW) goJF --info


## verify: Gradle verify code format task
verify:
	@echo ">> ============= Gradle verify code format task ============= <<"
	$(GRADLEW) verGJF --info


## ci: Run all CI tests.
ci: check verify
	@echo "\n==> All quality checks passed"


.PHONY: help