# Build

```
mvn clean install
```

# Run

This project can be run from the command line or with Docker.

## Run from Terminal 

```
java -jar target/config-service-0.0.1-SNAPSHOT.jar
```

## Run from Docker

To run from Docker the images must be built first:

```
docker build --tag config-service:latest .
```

This is the command to run the Docker image.
```
docker run --name config-service -p 8888:8888 config-service
```

Other useful commands:

```
docker exec -it config-service /bin/bash
docker stop config-service
docker rm config-service
```
