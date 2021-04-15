# Simple Kotlin Application Example

A simple console program example using Maven.

# TODO

- [ ] using logging
- [ ] fix [jacoco unit test coverage](https://kevcodez.de/posts/2018-08-19-test-coverage-in-kotlin-with-jacoco/)
- [ ] [format XML using spotless](https://github.com/diffplug/spotless/blob/main/plugin-maven/README.md)

## Objective

This is a command line program that:

* uses a command line argument to receive a `username` as a lower-case
  alphabetic string
* if no `username` given a usage message should be provided
* if an incorrect `username` is provided an error message should be reported
* if a correct `username` is given then save it into a database and return the inserted id of the new user as a message
* log the user id to a log file with ISO date

Here we will use the [H2 database](https://www.h2database.com/).

### References

* [H2 Database](https://www.h2database.com/)
* [Kotlin Commandline parser kotlinx-cli ](https://github.com/Kotlin/kotlinx-cli)
* [Kotlin JPA](https://www.baeldung.com/kotlin/jpa)
* [kotlin-logging](https://github.com/MicroUtils/kotlin-logging)
* [Kotlin Spring Boot application with H2 and JPA](https://code4spring.wordpress.com/2020/03/08/spring-boot-application-with-h2-and-jpa-using-kotlin-2/)
* [Spring Boot H2 Database](https://www.baeldung.com/spring-boot-h2-database)

## Sort POM

To sort POM run: (see [.m2/settings.xml](.m2/settings.xml))

```bash
mvn sortpom:sort
mvn sortpom:verify
```

Using full group and artefact:

```bash
mvn com.github.ekryd.sortpom:sortpom-maven-plugin:sort
mvn com.github.ekryd.sortpom:sortpom-maven-plugin:verify
```

## Format & Lint Code

To format code use:

```bash
mvn spotless:apply
mvn spotless:check
```

Using full group and artefact:

```bash
mvn com.diffplug.spotless:spotless-maven-plugin:2.9.0:apply
mvn com.diffplug.spotless:spotless-maven-plugin:2.9.0:check
```

See also configuration in [pom.xml](pom.xml).

## Run

Run the application with:

```bash
mvn exec:java -Dexec.args='-u frank'
mvn exec:java -Dexec.args='-h'
```

### Usage

```text
$ mvn exec:java -Dexec.args='-h'

Usage: CreateUser options_list
Options:
    --username, -u -> Username (always required) { String }
    --help, -h -> Usage info
```

## Reports

To generate reports and documentation run:

```bash
mvn clean site
```

Reports are published to GitHub pages
[here](https://frankhjung.github.io/kotlin-user/index.html).

## Documentation

Kotlin is similar to
[JavaDoc](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html).
It however doesn't support the same documentation annotations or build. Here we
are using [Dokka](https://github.com/Kotlin/dokka).

### References

* [KDoc & Dokka](https://kotlinlang.org/docs/kotlin-doc.html)
* [Dokka Maven Usage](https://kotlin.github.io/dokka/1.4.30/user_guide/maven/usage/)
* [Markdown used by KDoc](https://daringfireball.net/projects/markdown/)
