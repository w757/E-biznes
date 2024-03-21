# Ubuntu 22.04
FROM ubuntu:22.04


ENV DEBIAN_FRONTEND=noninteractive

# PPA for Python 3.8
RUN apt-get update \
    && apt-get install -y software-properties-common \
    && add-apt-repository ppa:deadsnakes/ppa -y \
    && apt-get update

# Java, Python 3.8, pip, Kotlin, Gradle, SQLite
RUN apt-get install -y \
        openjdk-8-jdk \
        python3.8 \
        python3.8-distutils \
        python3.8-dev \
        python3-pip \
        kotlin \
        gradle \
        libsqlite3-dev \
        sqlite3

# Python version 3.8
RUN ln -s /usr/bin/python3.8 /usr/bin/python

RUN pip3 install --upgrade pip \
    && pip3 install \
        setuptools \
        wheel

# Java version 8
RUN update-alternatives --set java /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java \
    && update-alternatives --set javac /usr/lib/jvm/java-8-openjdk-amd64/bin/javac


COPY build.gradle /app/


COPY hello_world.py /app/


WORKDIR /app


RUN gradle wrapper


CMD ["python", "hello_world.py"]
