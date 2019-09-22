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


## check: Gradle check code task
check:
	@echo ">> ============= Gradle check code task ============= <<"
	$(GRADLEW) check --info


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