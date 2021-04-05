# Kotlin Console Example

A simple console program example using Maven.

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
mvn ktlint:format
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
$ mvn exec:java -Dexec.args="one two three"
...
Got arguments:

one
two
three
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

## References

* [KDoc & Dokka](https://kotlinlang.org/docs/kotlin-doc.html)
* [Dokka Maven Usage](https://kotlin.github.io/dokka/1.4.30/user_guide/maven/usage/)
* [Markdown used by KDoc](https://daringfireball.net/projects/markdown/)
