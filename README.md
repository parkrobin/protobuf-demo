# Protobuf Demo

## 1. Overview

This is a demo project using Protobuf to serialize and deserialize data.
https://github.com/protocolbuffers/protobuf

## 2. Environment

```
Java: 21
libprotoc: 28.3
```

## 3. Run

```
 1. protoc --java_out=./src/main/java Person.proto
 2. mvn clean package
 3. java -jar .\target\protobuf-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
```
