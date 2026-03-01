# Quick-calc Project


## Project Description
This is a public repository for the project Quick-Calc. Quick-calc is a Java desktop calculator application built with the Swing GUI toolkit. It presents a simple window in which the user types two numeric values into dedicated input fields and then performs any of the four fundamental arithmetic operations, the user may choose the preferred action through the corresponding buttons on the interface. Once an operation button is pressed the result is computed and immediately; clicking "Calculate" then writes that result to the display field as a decimal number. A  clear button - (C) - resets all fields to their default state (0). The program accepts only Real numbers as values, ignoring non-numerical input. 

## Setup Instructions:

### Prerequisites: 
- **Java 11** and later
- **Apache Maven 3.6** and later

### Installing Java:
You can install **Oracle Java SE Development Kit (JDK)** from the official website of Oracle: [Website](https://www.oracle.com/java/technologies/downloads/). There you can select the latest available version of and download the installer to your OS:

| OS | Recommended method |
|---|---|
| **Windows** | Use **.exe** installer  |
| **Linux** | Extract **.tar.gz** archive |
| **macOS** | Use **.dmg** installer |

- **Windows / macOS:** You can run the installer that will set all environment variables automatically.
- **Linux:** You can exctract the archives and set the `PATH` environment variables manually.

### To check Java version
You can run the following command in command console (cmd) to verify the version of the installation:
```
java -version
```


### Installing Maven:
You can download the installer from the official maven website: [Maven](https://maven.apache.org/download.cgi). 
| OS | Recommended method |
|---|---|
| **Windows** | Download the installer, unzip, and add `bin/` to your `PATH` manually |
| **macOS** | Use `brew install maven` |
| **Ubuntu / Debian** | Use `sudo apt install maven` |
| **Fedora** | Use `sudo dnf install maven` |


### To check Maven version
You can run the following command in command console (cmd) to verify the version of the installation:
```
mvn -version
```


### Install dependencies
To automatically download the declared dependencies just run the following command from the root folder of the project (folder with pom.xml file):
```
mvn compile
```

## To run the application you can:
|#| Methods |
|---|---------|
|1|Execute the "Calculator_main.java" file manually `in scr/main/java`.|
|2|Run: `mvn exec:java -Dexec.mainClass="Calculator_main"`.|


## To run tests you can:
Run the following command from the root directory:
```
mvn test
```

## Testing Frameworks Research
As the app was written in java, only two testing frameworks were mainly considered for the research - **JUnit 5** and **TestNG**. Those two frameworks may be considered the most popular options when it comes to the testing of the software in java.

**JUnit** is the de-facto standard for Java unit testing and the most widely adopted framework. Its modular architecture - split into the Platform, Jupiter API, and Vintage engine - makes it highly extensible. The **@Nested** and **@DisplayName** class support is excellent for organising related tests into logical groups and allow for much easier human analysis of IDE and CI reports. Most importantly, JUnit posses a great degree of support for lots of build tools, such as Maven and virtually every major Java IDE, it requires almost zero additional configuration and installments.  

**TestNG** was originally designed to address shortcomings of early JUnit versions and remains a strong choice for large enterprise test suites. It's main features include native support for parameterised tests flexible test grouping and dependency declarations and, most importantly, parallel testing execution control. However, TestNG is much harder to learn and properly use, as well as configure than **JUnit**.

This project required the most basic methods of testing and no advanced setups or pararell testing with external dependencies. Therefore the **JUnit** seemed like the most reasonable choice due to the specific characteristics of this project. 

