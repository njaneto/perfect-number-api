# Perfect Number API

Checks if a number is perfect, given the following specifications,
perfect number rule: http://en.wikipedia.org/wiki/Perfect_number;

### Prerequisites

Requirements for the software and other tools to build, test and push

- [Java](https://www.java.com/pt-BR/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Kubernetes](https://kubernetes.io/docs/home/) - optional

## Todo - 😅 👨‍💻

- [x] Initial work - 🥳
- [X] Test units - 😏
- [X] Dockerfile - 🥹
- [X] Kubernetes - 😝

## Running the tests

```
    mvn clean install
```

## Postman

import [Collection](./doc/Collection-PerfectNumber.postman_collection.json)

## Deployment

```
    docker build -t <name-space>/perfect-number-api:<tag> <path>/Dockerfile
```

## Start API 

```
    docker run -it --name perfect-number-api -p 8080:808O <name-space>/perfect-number-api:<tag>
```

### Contributing Authors

* **Nilo Jose de Andrade Neto** - *Initial work*
