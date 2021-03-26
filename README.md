# Laboratory 6

At the last laboratory I finished the compulsory and optional.

This repository is for the tasks given at laboratory 6.

## Essential tools

You need to have Java RE or JDK >= 10 installed on your computer.

## How to run it?

1. Open project with IntelliJ IDEA

Clone this repository and open it with IntelliJ IDEA. Build this project
(shortcut Ctrl+F9) then go to Run->Run...(shortcut Alt+Shift+F10) and select the file you want to run.

2. Compile and run the programs using CMD

Go to the folder where the file is located. Open a new terminal here.

If you want to compile the file Main.java you must type the command.

```bash
javac -d . Main.java
```

After you compiled it, if you want to start the program you can type the following command

```bash
java packageName.Main
```

where to packageName is the name of the package which includes the file Main.java.

### Lombok

I also used lombok to generate simple methods for each class: setters,getters constructors etc. To use lombok in your
project the fallowing dependency must be added to the Maven project:

```html

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
    <scope>provided</scope>
</dependency>
```

Then we simply use keywords like @Setter @Getter @EqualsAndHashCode etc. More information about this can be found at:
[projectlombok.org](https://projectlombok.org/features/all)

### log4j2

For the laboratory i also used log4j to print elements instead of System.out.print and System.err.print due to
efficiency reasons. To use log4j you first need to add the dependency for the Maven project:

```html

<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.13.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.13.0</version>
</dependency>
```

Then, you’re going to need a logger instance. Add the following line to the start of your class:

```dif
private static final Logger logger=LogManager.getLogger(ClassName.class);
```

Finally, use the following functions in your main class, just after printing the message:

```dif
logger.trace("Test Trace!");
        logger.debug("Test Debug!");
        logger.info("Test Info!");
        logger.warn("Test Warn!");
        logger.error("Test Error!");
        logger.fatal("Test Fata;!");
```

However,as it turns out, we haven’t configured Log4j2, which means it has resorted to its default configuration. The
default configuration simply logs to the console log entries with the level configured as “error” or higher. That’s why
the messages with levels debug, trace, info, and were not logged. For the last step you will need to add a new file
inside the folder resources located at "path_to_project\src\resources" , named log4j2.xml with the fallowing xml code
inside:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="FileAppender" fileName="application-${date:yyyyMMdd}.log" immediateFlush="false" append="true">
            <PatternLayout pattern="%d{yyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="ConsoleAppender"/>
            <AppenderRef ref="FileAppender"/>
        </Root>
    </Loggers>
</Configuration>
```

You're good to go! Now you should be able to see in the console what the other methods print too.

## Compulsory

The task consists of:<br />

- [X] The main frame of the application.
- [X] A configuration panel for introducing parameters regarding the shapes that will be drawn: the size, the number of
  sides, the stroke, etc.
- [X] The panel must be placed at the top part of the frame. The panel must contain at least one label and one input
  component for specifying the size of the component.
- [X] A canvas (drawing panel) for drawing various types of shapes. You must implement at least one shape type at your
  own choice. This panel must be placed in the center part of the frame.
- [X] When the users execute mouse pressed operation, a shape must be drawn at the mouse location. You must use the
  properties defined in the configuration panel (at least one) and generate random values for others (color, etc.).
- [X] A control panel for managing the image being created. This panel will contain the buttons: Load, Save, Reset, Exit
  and it will be placed at the bottom part of the frame.
- [X] Use a file chooser in order to specify the file where the image will be saved (or load).



## Optional

The task consists of:<br />

- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 

Here is the output I received:<br />

```dif

```

## Bonus

The task consists of:<br />

- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 
- [X] 

Here is the output I received:<br />
