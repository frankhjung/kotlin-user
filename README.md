# Simple Kotlin Application Example

A simple console program example using Maven.

## Objective

This is a command line program that:

* uses a command line argument to receive a username as a lower-case
  alphabetic string
* if no username given a usage message should be provided
* if an incorrect username is provided an error message should be reported
* if a correct username is given then save it into a database and return the inserted id of the new user as a message
* log the user id to a log file with ISO date

Here we will use the H2 database.

### References

* [Kotlin Commandline parser kotlinx-cli ](https://github.com/Kotlin/kotlinx-cli)
* [Kotlin JPA](https://www.baeldung.com/kotlin/jpa)
* [Kotlin Spring Boot application with H2 and JPA](https://code4spring.wordpress.com/2020/03/08/spring-boot-application-with-h2-and-jpa-using-kotlin-2/)
* [Spring Boot H2 Database](https://www.baeldung.com/spring-boot-h2-database)
* [kotlin-logging](https://github.com/MicroUtils/kotlin-logging)

## Sort POM

To sort POM run:

```bash
mvn com.github.ekryd.sortpom:sortpom-maven-plugin:sort
```

Or the short version which depends on [.m2/settings.xml](.m2/settings.xml)

```bash
mvn sortpom:sort
```

## Format Code

To format code with:

```bash
mvn com.github.gantsign.maven:ktlint-maven-plugin:1.8.0:format
```

Or the short version which depends on [.m2/settings.xml](.m2/settings.xml)

```bash
mvn spotless:apply
```

## Lint Code

To check code using
the [ktlint](https://github.com/gantsign/ktlint-maven-plugin) use:

```bash
mvn com.github.gantsign.maven:ktlint-maven-plugin:1.8.0:check
```

Or the short version: which depends on [.m2/settings.xml](.m2/settings.xml)

```bash
mvn ktlint:check
```

## Run

Run the application with:

```bash
$ mvn exec:java -Dexec.args="-v -u frank"
```

## Reports

To generate reports run:

```bash
mvn clean site
```

## Documentation

Kotlin is similar to JavaDoc. It however doesn't support the same documentation
annotations or build. Here we are using
[Dokka](https://github.com/Kotlin/dokka).

### References

* [KDoc & Dokka](https://kotlinlang.org/docs/kotlin-doc.html)
* [Dokka Maven Usage](https://kotlin.github.io/dokka/1.4.30/user_guide/maven/usage/)
* [Markdown used by KDoc](https://daringfireball.net/projects/markdown/)
