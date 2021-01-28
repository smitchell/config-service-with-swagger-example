# Spring Configuration Example

This multi-module project demonstrates the Spring Config Service.

There are two Spring Boot projects:
1) Config Server, running on port 8888
1) Sample Client, running on port 8181

There is one local Git repository:
1) Config Repo

NOTE: The Config Server expects to find the config repo in your home directory. We set that up below.

When an application calls the configuration service to get properties, the configuration service looks in the Git repository for a property file matching the application's name. The Sample Client has a "message" that is read from the Config Server. If the server or property is unavailable, it returns "Hello Default."

## Getting Started

This project uses a local property file to simulate properties in Git.
1) Create a folder in your **home directory** named "config-repo". 
1) Copy config-repo/sample-client.yml into your config-repo directory created in step one.
1) Initialize git in the config-repo directory and commit the file.

```
git init
git add sample-client.yml
git commit sample-client.yml -m "Initial Commit"
```

The application.yml in the Configuration Service points to file://${user.home}/config-repo. 
NOTE: For windows, you need an extra slash "file:///${user.home}/config-repo"

Build the project.

```
mvn clean install
```

## Start the sample client by itself

Run the sample client project by itself. Call the /message endpoint. 

```
java -jar sample-client/target/sample-client-0.0.1-SNAPSHOT.jar 
```

Open http://localhost:8181/api/message/100 or use curl in a separate window.

```
curl localhost:8181/api/message/100
```

The result should be "Hello default." Press CNTL-C to stop the sample client.

Stop the sample client.

## Start the configuration service followed by the sample client.

In separate terminals or IDE windows, start the configuration service and then the sample client.

Start the configuration service
```
java -jar config-service/target/config-service-0.0.1-SNAPSHOT.jar
```

Once the configuration service is running, restart the sample client.
```
java -jar sample-client/target/sample-client-0.0.1-SNAPSHOT.jar
```

Open http://localhost:8181/api/message/100 or use curl in a separate window:

```
curl localhost:8181/api/message/100
```

The result should be "Hello world" from the sample-client.yml file int he git repository.

# Demonstrate Refresh

Change the message in the user home Git repository and commit the change.

```
vi sample-client.yml
git commit -a -m "Updated value"
```

Issue a POST to the refresh endpoint to trigger a refresh.
```
curl -X POST localhost:8181/actuator/refresh
```

Open http://localhost:8181/api/message/100 or use curl in a separate window to see the new vaulue.

```
curl localhost:8181/api/message/100
```
The newly committed message should appear.

# Swagger

The raw Swagger JSON is available here:

```
curl http://localhost:8181/v2/api-docs
```

# Running with Docker Compose

The project demonstrates running docker locally for testing

## Building

```
docker-compose build
```

## Running

```
docker-compose up
```

Open http://localhost:8181/api/message/100 or use curl in a separate window to see the new vaulue.

```
curl localhost:8181/api/message/100
```

## Stopping

```
docker-compose down
```


