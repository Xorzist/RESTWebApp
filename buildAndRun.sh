#!/bin/sh
mvn clean package && docker build -t egov.rphipps/RESTWebApp .
docker rm -f RESTWebApp || true && docker run -d -p 8080:8080 -p 4848:4848 --name RESTWebApp egov.rphipps/RESTWebApp 
