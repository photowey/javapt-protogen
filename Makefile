SHELL := /bin/bash


MVN ?= $(if $(MVND_HOME),mvnd,mvn)

.PHONY: clean compile test deploy package tree check

.DEFAULT_GOAL := help

dir:
	@echo "Current directory: $(CURDIR)"

clean: dir
	@echo "Cleaning the project..."
	$(MVN) clean

compile: clean
	@echo "Using $(MVN) to compile the project..."
	$(MVN) compile

test: clean
	@echo "Using $(MVN) to test the project..."
	$(MVN) test

deploy: clean
	@echo "Using $(MVN) to deploy the project..."
	$(MVN) -DskipTests=true source:jar deploy

package: clean
	@echo "Using $(MVN) to package the project..."
	$(MVN) -DskipTests=true package

tree:
	@echo "Using $(MVN) to show dependency tree..."
	$(MVN) dependency:tree -Dincludes=$(filter-out $@,$(MAKECMDGOALS))

check:
	@echo "Using $(MVN) to check the project..."
	$(MVN) checkstyle:check

help:
	@echo "Available targets:"
	@echo "  clean     - Clean the project"
	@echo "  compile   - Compile the project"
	@echo "  test      - Run tests"
	@echo "  deploy    - Deploy the project"
	@echo "  package   - Package the project"
	@echo "  tree      - Show dependency tree (e.g., make tree group:artifact)"
	@echo "  check     - Check the project"
	@echo "  help      - Show this help message"

%:
	@echo "Unknown target: $@"
	@echo "Use 'make help' to see available targets."
