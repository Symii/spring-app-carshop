# CarShop

---

## Opis

Aplikacja **CarShop-Spring** to aplikacja REST-API.

## Funkcje

- **GET** `http://localhost/api/cars`
- **GET** `http://localhost/api/cars/1`
- **GET** `http://localhost/api/cars/random`
- **GET** `http://localhost/api/cars/search/findByKeyword?keyword=Audi`
- **GET** `http://localhost/api/cars/filter?page=0&size=12&brand=Audi&body=sedan&priceFrom=0&priceTo=90000&yearProducedFrom=2016&fuelType=benzyna`
  
- **PUT** `http://localhost/api/cars`
- **POST** `http://localhost/api/cars`
- **DELETE** `http://localhost/api/cars/{carId}`

 @RequestBody Annouance annouance
- **POST** `http://localhost/api/annouance/new`

## Technologie

Aplikacja została zbudowana w oparciu o framework **Spring Boot**.

## Uruchomienie lokalne

1. **Klonowanie repozytorium:** Sklonuj to repozytorium na swoje lokalne środowisko.
   ```bash
   git clone https://github.com/symii/spring-app-carshop.git
2. **Konfiguracja bazy danych MYSQL - utwórz baze danych o nazwie car_shop
   ```bash
   create database car_shop;
3. **Uruchomienie Apache Kafka**
   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   bin/kafka-server-start.sh config/server.properties
4. **Uruchomienie aplikacji:** Przejdź do katalogu z aplikacją i uruchom ją za pomocą narzędzia Maven.
    ```bash
    cd spring-app-carshop
    mvnw spring-boot:run
5. **Przeglądanie:** Otwórz przeglądarkę internetową i przejdź pod adres.
    ```bash
     http://localhost:80/api/cars
6. **Frontend:** [Teraz możesz uruchomić projekt Angular](https://github.com/Symii/angular-app-carshop/)



