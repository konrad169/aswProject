# Architettura dei Sistemi Software a Roma Tre (2019)

Benvenuti al repository del progetto finale del corso 
di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/) 
a Roma Tre, 
edizione 2019 (A.A. 2018-2019), 
tenuto dal prof. [Luca Cabibbo](http://cabibbo.dia.uniroma3.it/)
Realizzato dagli studenti :  
* Conti Ludovico
* Costa Danilo
* Silvestri Corrado. 

Questo repository contiene il codice per la realizzazione di una semplice applicazione distribuita composta da una terna di servizi replicati che comunicano tra loro tramite invocazioni remote con REST, utilizzando Eureka per il service discovery,Kafka per lo streaming dei messaggi(message broker) Feign e Ribbon rispettivamente per effettuare chiamate rest e load balancing delle richieste e Zuul come API Gateway.Il progetto fa riferimento al caso 2 del [progetto](http://cabibbo.dia.uniroma3.it/asw/progetti/asw-progetto.pdf) pubblicato dal prof. Luca Cabibbo

## Software da installare sul proprio PC 
Per l'ambiente Amiente di Sviluppo:
* [Java SDK](http://www.oracle.com/technetwork/java/javase/) 
* [Git](https://git-scm.com/) 
* [Gradle](http://gradle.org/) 
* [VirtualBox](https://www.virtualbox.org/)
* [Kafka](https://kafka.apache.org/)

Per l'ambiente di Ambiente di Deployment
* [Java SDK](http://www.oracle.com/technetwork/java/javase/) 
* [Kafka](https://kafka.apache.org/)


## Configurazione di Kafka richiesta
E' necessario che il servizio kafka sia in esecuzione e che sul messageBroker sia presente il topic asw.kafka.channel.alpha composta da 4 partizioni e 1 replica.

Se tale topic non e' presente recarsi nella home di kafka ed eseguire  
```
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4 --topic asw.kafka.channel.alpha
```

## Organizzazione del repository 

Questo repository è organizzato in diverse sezioni (cartelle): 
* [A-service](A-service/) contiene il codice del *servizio A*, 
  che effettua due operazioni REST, GET, invocando tramite feign il servizio getAllMessage() del Servizio C;
  POST invia un messaggio al servizio B che si occuperˆ di gestirlo.
* [B-service](B-service/) contiene il codice del *servizio B* che riceve una chiamata POST dal servizio A, effettua un'operazione sul messaggio e invocando tramite feign il postMessage() del Servizio C invia il messaggio. 
* [C-service](C-service/) contiene il codice del *servizio C* che riceve sia chiamate POST da B,  memorizzandolle in una lista, che chiamate GET da A, restituendo la collezione.
* [asw-service-api-rest](asw-service-api-rest/) Contiene le API REST ed il codice per creare un Message request.
* [eureka-server](eureka-server/) contiene il codice necessario per un server Eureka
* [zuul-gateway](zuul-gateway/) contiene il codice necessario per Zuul 

## Come eseguire la build e avviare l'applicazione (Multiple-Istance). 

1) Posizionarsi nella cartella [root](.)
2) Effettuare la build automatica di gradle tramite lo script ./build-all.sh oppure per ogni cartella presente nel repository, posizionarsi in essa, ed effettuare la build manuale tramite il comando 'gradle build'
3) Una volta completate tutte le build , eseguire lo script ./run-service-multiple-instances.sh presente nella directory principale della cartella ,per eseguire il progetto con i servizi in maniera replicata. 
4) Per terminare l'applicazione sará necessario eseguire lo script ./stop-java-process.sh. 

## Come eseguire la build e avviare l'applicazione (Single-Istance)
1) Posizionarsi nella cartella [root](.)
2) Effettuare la build automatica di gradle tramite lo script ./build-all.sh oppure per ogni cartella presente nel repository, posizionarsi in essa, ed effettuare la build manuale tramite il comando 'gradle build'
3) Una volta completate tutte le build , eseguire lo script ./run-service-single-instance.sh presente nella directory principale della cartella ,per eseguire il progetto con i servizi in maniera non replicata. 
4) Per terminare l'applicazione sará necessario eseguire lo script ./stop-java-process.sh. 


## Esposizione dei servizi sulle porte
Il servizio zull e' esposto sulla porta 8080 ed e' incaricato di inoltrare le richeste fatte sulla porta 8080 al servizio principale serviceA.
L'assegnazione delle porte dei servizi serviceA, serviceB, serviceC avviene in maniera casuale.
Il servizio di ServiceDiscovery Eureka e' incaricato di acquisire gli indirizzi dei servizi in esecuzione.

* Nota:  
A seguito di un bug rilevato sulla versione di org.springframework.cloud:spring-cloud-starter-netflix-eureka-client che entra in conflitto con l'attribuzione randomica della porta ad un servizio in cui é abilitato il ServiceDiscoveryClient,
nello script di avvio viene sovrascritta la porta di esecuzione come segue:

Gli script "run-service-multiple-istance/single-istance" assegnano alle varie istanze A, B ,C delle porte prefissate per ovviare il problema: 
* Single istance:  
A:8290  
B:8090  
C:8190  

* Multiple istance:  
A:8290,8291,8393  
B:8090,8091,8092  
C:8190,8191  
