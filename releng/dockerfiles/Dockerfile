# Copyright (c) 2023 Polytechnique de Montréal
#
# All rights reserved. This program and the accompanying materials are made
# available under the terms of the Eclipse Public License 2.0 which
# accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
###################################orginal Dockerfile#################################3
# FROM alpine:3.16.0 as packager

# RUN apk --no-cache add openjdk17-jdk openjdk17-jmods maven

# COPY ./ /app/

# WORKDIR /app/

# RUN mvn clean install -DskipTests -Dskip-rcp -Pfilter-grammar -Pctf-grammar

# FROM alpine:3.16.0

# COPY --from=packager /root/.m2/repository/org/eclipse/tracecompass /root/.m2/repository/org/eclipse/tracecompass

# Use the official Ubuntu image as the base image
FROM ubuntu:latest

# Set the maintainer label
LABEL maintainer="your-email@example.com"

# Update system and install OpenJDK 17
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    && rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64

# Set PATH environment variable
ENV PATH $JAVA_HOME/bin:$PATH

# Verify installation
RUN java -version

# Copy your application code (assuming a jar file for a Java app)
# COPY your-app.jar /usr/app/
# WORKDIR /usr/app
# CMD ["java", "-jar", "your-app.jar"]

# Open the port your app runs on, if applicable
# EXPOSE 8080
