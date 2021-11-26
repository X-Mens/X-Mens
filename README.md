# Code Challenge: XMen

It was implemented with the use of Java + Spring Boot, Redis for cache and Dynamodb.

## Prerequisitos

* java, maven, docker, docker-compose, git

## How does it execute?

* First, you should clone the repository
```console
crkjohn@crkjohn:~$ git clone https://github.com/X-Mens/X-Mens.git
crkjohn@crkjohn:~$ cd X-Mens 
crkjohn@crkjohn:~$ mvn package
```

### Run project on Docker
```console
crkjohn@crkjohn:~$ docker build . --tag x-men
```

* once the image has been created, we now have to deploy the rest of the architecture

```console
crkjohn@crkjohn:~$ docker-compose -f docker-componse.yaml up --build
```

* one the rest of architecture is running, you can start the application 


```console
crkjohn@crkjohn:~$ docker run -p8080:8080 xmen:latest
```

Be careful on which network card your containers run on, in the case of ubuntu there is a special network card for network and therefore, it is necessary to modify the application.yaml and change the broker to the ip of the docker network card.

```yaml
        .
        . configuration
        .
      kafka:
        binder:
          brokers:  IP Network card docker 
```

### Run local

You just need to run the following commands in different terminals

```console
crkjohn@crkjohn:~$ docker-compose -f docker-componse.yaml up --buil
crkjohn@crkjohn:~$ java -jar target/xmens-0.0.1-SNAPSHOT.jar
```

## API

### Request to /mutant endpoint

```bash
curl --location --request POST 'https://ycfior86f8.execute-api.us-east-1.amazonaws.com/v1/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna" :["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}'
```

### Request to /stat endpoint
```bash
curl --location --request GET 'https://ycfior86f8.execute-api.us-east-1.amazonaws.com/v1/stat'
```

## Architecture AWS
 
### Architecture with this project

![](https://github.com/CrkJohn/ConfigFilesExample/blob/develop/NoServeless.png)

### Architecture serveless 
*for ease and time issues, I decided to deploy the serveless service, the algorithm is the same as the one used in this project to solve the problem.*

![](https://github.com/CrkJohn/ConfigFilesExample/blob/develop/Serveless.png)


* Dna Lambda link project 
    [Link](https://github.com/X-Mens/DnaLambda)
* Stat Lambda link project 
    [Link](https://github.com/X-Mens/DnaLambda)
Infra As Code
    [IaC](https://github.com/X-Mens/IaC-XmensServeless)


## Software architecture

Comming soon

### Autor

John David Ibañez - [CrkJohn](https://github.com/CrkJohn)
