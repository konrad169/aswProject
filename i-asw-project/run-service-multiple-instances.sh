#!/bin/bash
# Script per avviare l'applicazione Servoce in multi-instances
echo Running Services [Eureka]
echo Starting Eureka Server
java -Xms64m -Xmx128m -jar ./eureka-server/build/libs/eureka.jar &
echo Starting ServiceC Services [ServiceC*2]
java -Xms64m -Xmx128m -jar ./C-service/build/libs/serviceC.jar --instanceName=Carlo --server.port=8190 &
java -Xms64m -Xmx128m -jar ./C-service/build/libs/serviceC.jar --instanceName=Camilla --server.port=8191 &
echo Starting ServiceB Services [ServiceB*3]
java -Xms64m -Xmx128m -jar ./B-service/build/libs/serviceB.jar --instanceName=Benedetta --server.port=8090 &
java -Xms64m -Xmx128m -jar ./B-service/build/libs/serviceB.jar --instanceName=Beatrice --server.port=8091 &
java -Xms64m -Xmx128m -jar ./B-service/build/libs/serviceB.jar --instanceName=Bianca --server.port=8092 &
echo Starting ServiceA Services [ServiceA*3]
java -Xms64m -Xmx128m -jar ./A-service/build/libs/serviceA.jar --instanceName=Anita --server.port=8290 &
java -Xms64m -Xmx128m -jar ./A-service/build/libs/serviceA.jar --instanceName=Arianna --server.port=8291 &
java -Xms64m -Xmx128m -jar ./A-service/build/libs/serviceA.jar --instanceName=Aldo --server.port=8393 &
echo Starting Zuul-Gateway Services [Zuul*1]
java -Xms64m -Xmx128m -jar ./zuul-gateway/build/libs/zuul.jar &
echo Entired Application Started


