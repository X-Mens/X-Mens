# X-Men

## Prerequisitos

* docker-compose
* git

## Clone project

 
* First, you should clone the repository
```console
crkjohn@crkjohn:~$ git clone https://github.com/X-Mens/X-Mens.git
crkjohn@crkjohn:~$ cd X-Mens 
```

### How to run project local on Docker


* You just run only the following command on root folder project

```console
crkjohn@crkjohn:~$ docker-compose -f docker-componse.yaml up --build
```

* Once the container is running, you can consume the service the following [url](http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config) 

you can also see the status of the containers in portainer, you can enter in this [link](http://localhost:9999/#!/1/docker/dashboard)


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
