FROM openjdk:11.0-jdk-slim
RUN apt-get update && apt-get install -y --no-install-recommends \
    git \
    openssh-client \
    procps \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

RUN mkdir /root/config-repo &&\
    cd /root/config-repo &&\
    git config --global user.name "root" && \
    git config --global user.email "steve.mitchell@ahead.com" && \
    git init

COPY config-repo/sample-client.yml /root/config-repo/sample-client.yml

RUN cd /root/config-repo &&\
    git add sample-client.yml &&\
    git commit -m "Initial commit"

WORKDIR /

EXPOSE 8888

ENTRYPOINT ["java","-jar","/app.jar"]
