JAVAC=/usr/bin/javac
JAVA=/usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin


# List of Java source files
SOURCES = $(wildcard $(SRCDIR)/**/*.java)

# List of class files to be built
CLASSES = $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

# Compile Java source files to class files
$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR) -cp $(SRCDIR) $<

# Default target: build all class files
default: $(CLASSES)

# Clean target: remove all class files
clean:
	rm -f $(CLASSES)

# Run target: build and run the Main class
run: default
	$(JAVA) -cp $(BINDIR) MonteCarloMini.MonteCarloMinimizationParallel $(ARGS)

.PHONY: default clean run

 
