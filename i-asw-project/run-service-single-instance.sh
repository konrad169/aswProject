#!/bin/bash
# Script per avviare l'applicazione Service in multi-instances
echo Running Services
echo Starting Eureka Server
java -Xms64m -Xmx128m -jar ./eureka-server/build/libs/eureka.jar &
echo Starting ServiceC Service
java -Xms64m -Xmx128m -jar ./C-service/build/libs/serviceC.jar --instanceName=Carlo --server.port=8190 &
echo Starting ServiceB Service
java -Xms64m -Xmx128m -jar ./B-service/build/libs/serviceB.jar --instanceName=Benedetta --server.port=8090 &
echo Starting ServiceA Service
java -Xms64m -Xmx128m -jar ./A-service/build/libs/serviceA.jar --instanceName=Anita --server.port=8290 &
echo Starting Zuul-Gateway Service
java -Xms64m -Xmx128m -jar ./zuul-gateway/build/libs/zuul.jar &
echo Entired Application Started


