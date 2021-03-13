<p align="center">
	<img alt="Decoy Logo" src="https://raw.githubusercontent.com/Clivern/Decoy/master/images/logo.png" height="150" />
	<h3 align="center">Decoy</h3>
	<p align="center">JSON Schema Validation Package for Java.</p>
	<p align="center">
        <a href="https://github.com/clivern/decoy/actions/workflows/ci.yml">
            <img src="https://github.com/clivern/decoy/actions/workflows/ci.yml/badge.svg">
        </a>
        <a href="http://www.javadoc.io/doc/com.clivern/decoy">
            <img src="http://www.javadoc.io/badge/com.clivern/decoy.svg">
        </a>
        <a href="https://mvnrepository.com/artifact/com.clivern/decoy/0.1.0">
            <img src="https://img.shields.io/maven-central/v/com.clivern/decoy.svg">
        </a>
        <a href="https://github.com/clivern/decoy/blob/main/LICENSE">
            <img src="https://img.shields.io/badge/LICENSE-Apache_2.0-orange.svg">
        </a>
	</p>
</p>

Decoy is a Java implementation for the [JSON Schema Standard](https://json-schema.org/) (`draft-03`, `draft-04`, `draft-06` and `draft-07`), that will help you validate all sorts of JSON documents, whether they are configuration files or a set of data sent to a RESTful API endpoint.


## Documentation

### Installation

To add a dependency using Maven, use the following:

```xml
<dependency>
    <groupId>com.clivern</groupId>
    <artifactId>decoy</artifactId>
    <version>0.1.0</version>
</dependency>
```

To add a dependency using Gradle, use the following:

```java
dependencies {
    compile 'com.clivern:decoy:0.1.0'
}
```

To add a dependency using Scala SBT, use the following:

```java
libraryDependencies += "com.clivern" % "decoy" % "0.1.0"
```


### Usage

First import & initialize all required classes.

```java
import com.clivern.decoy.util.FileReader;
import com.clivern.decoy.SchemaFactory;
import com.clivern.decoy.Validator;


FileReader fileReader = new FileReader();
SchemaFactory schemaFactory = new SchemaFactory();
Validator validator = new Validator();
```

Then validate the `JSON` string against the `JSON Schema`.

```java
import com.clivern.decoy.SchemaDraft3;


// For SchemaDraft3
SchemaDraft3 schemaDraft3 = schemaFactory.unserialize(
    fileReader.readFileAsString("path/to/endpoint/schema03_definition.json"),
    SchemaDraft3.class
);

validator.validate(schemaDraft3, "{...JSON_DATA_HERE...}");  // returns Boolean (true || false)
validator.hasErrors();                                       // returns Boolean (true || false)
validator.getErrors();                                       // returns ArrayList<String>
```

```java
import com.clivern.decoy.SchemaDraft4;


// For SchemaDraft4
SchemaDraft4 schemaDraft4 = schemaFactory.unserialize(
    fileReader.readFileAsString("path/to/endpoint/schema04_definition.json"),
    SchemaDraft4.class
);

validator.validate(schemaDraft4, "{...JSON_DATA_HERE...}");  // returns Boolean (true || false)
validator.hasErrors();                                       // returns Boolean (true || false)
validator.getErrors();                                       // returns ArrayList<String>
```

```java
import com.clivern.decoy.SchemaDraft6;


// For SchemaDraft6
SchemaDraft6 schemaDraft6 = schemaFactory.unserialize(
    fileReader.readFileAsString("path/to/endpoint/schema06_definition.json"),
    SchemaDraft6.class
);

validator.validate(schemaDraft6, "{...JSON_DATA_HERE...}");  // returns Boolean (true || false)
validator.hasErrors();                                       // returns Boolean (true || false)
validator.getErrors();                                       // returns ArrayList<String>
```

```java
import com.clivern.decoy.SchemaDraft7;


// For SchemaDraft7
SchemaDraft7 schemaDraft7 = schemaFactory.unserialize(
    fileReader.readFileAsString("path/to/endpoint/schema07_definition.json"),
    SchemaDraft7.class
);

validator.validate(schemaDraft7, "{...JSON_DATA_HERE...}");  // returns Boolean (true || false)
validator.hasErrors();                                       // returns Boolean (true || false)
validator.getErrors();                                       // returns ArrayList<String>
```


### Examples

```java
#
```

## Versioning

For transparency into our release cycle and in striving to maintain backward compatibility, Decoy is maintained under the [Semantic Versioning guidelines](https://semver.org/) and release process is predictable and business-friendly.

See the [Releases section of our GitHub project](https://github.com/clivern/decoy/releases) for changelogs for each release version of Decoy. It contains summaries of the most noteworthy changes made in each release.


## Bug tracker

If you have any suggestions, bug reports, or annoyances please report them to our issue tracker at https://github.com/clivern/decoy/issues


## Security Issues

If you discover a security vulnerability within Decoy, please send an email to [hello@clivern.com](mailto:hello@clivern.com)


## Contributing

We are an open source, community-driven project so please feel free to join us. see the [contributing guidelines](CONTRIBUTING.md) for more details.


## License

© 2019, Clivern. Released under [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

**Decoy** is authored and maintained by [@Clivern](http://github.com/clivern).
