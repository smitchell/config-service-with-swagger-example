# Build

```
mvn clean install
```

# Run

This project can be run from the command line or with Docker.

## Run from Terminal 

```
java -jar target/sample-client-0.0.1-SNAPSHOT.jar
```

## Run from Docker

To run from Docker the images must be built first:

```
docker build --tag sample-client:latest .
```

This is the command to run the Docker image.
```
docker run --name sample-client -p 8181:8181 sample-client 
```

Other useful commands:

```
docker stop sample-client
docker rm sample-client
```
