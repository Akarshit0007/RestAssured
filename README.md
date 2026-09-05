# REST Assured TestNG Framework

Reusable API automation framework built with Java 21, REST Assured, and TestNG.

## Prerequisites

- JDK 21 or newer
- Maven 3.9 or newer

## Run tests

```powershell
mvn clean test
```

Choose an environment without changing source code:

```powershell
mvn clean test -Denv=qa -DbaseUrl=https://your-api.example.com
```


## Structure

```text
src/main/java/com/banking/inc/framework
  config      Configuration loading
  client      Reusable API client abstractions
src/test/java/com/banking/inc/tests
  base        Test lifecycle and common assertions
  smoke       Example API smoke tests
src/test/resources
  config      Environment properties
  testng.xml  TestNG suite
```

Test reports are written to `target/surefire-reports`.
