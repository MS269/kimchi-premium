# Kimchi Premium

## Setup

- IDE: IntelliJ IDEA
- SDK: Amazon Corretto Version 21

### application.properties

Setup src/main/resources/application.properties

- spring.datasource.password=your_password

### compose.yaml

Setup compose.yaml

- MYSQL_ROOT_PASSWORD=your_password

Then run

```shell
docker compose up
```

## Build

```shell
./gradlew build
```

```shell
./gradlew bootjar # only build .jar in build/libs
```
