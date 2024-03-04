# Kimchi Premium

## Setup

- IDE: IntelliJ IDEA
- SDK: Amazon Corretto Version 21

### Docker Compose

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
