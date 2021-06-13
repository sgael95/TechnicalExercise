## Clone Repo
Navigate to desired location on command line

To clone the repo use the following command
```
git clone https://github.com/sgael95/TechnicalExercise.git
```

## Requirements
To run project you will need:
- [Git Cli](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) installed on machine
- [Java](https://www.java.com/en/download/help/download_options.html) installed on machine
- [Maven](https://maven.apache.org/install.html) installed on machine

### Test Program

Navigate to root program folder

Now type the following commands

```
mvn package
```
Validate, Compile and Test phases will be executed

Can also use the following to unit test
```
mvn test
```

### Run compiled and packaged jar

The following command can be used to run the jar.
```
java -jar target/Gael-Sanchez-Full-Stack-Technical-Exercise-0.0.1-SNAPSHOT-spring-boot.jar <Path to File>
```
I have also added a text file **TestFile.txt** with sample data formated how I theorized the data would be presented.

```
java -jar target/Gael-Sanchez-Full-Stack-Technical-Exercise-0.0.1-SNAPSHOT-spring-boot.jar TestFile.txt
```

## Project Assumptions
There were a few details left out of the assignment document that led me to make some assumptions.
* The label paper will be a rectangular shape.
* A label would simply be a word or collection of words that can be cut out of the label paper.
* Data provided would be in a text file with a single label per line.
Example
```
Label1
Label2
Label3
...
```

