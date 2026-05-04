# Prog Officina API

Evoluzione backend Spring Boot del progetto Java console "ProgOfficina".

## Descrizione
Applicazione REST API per la gestione di un inventario veicoli, sviluppata per consolidare competenze in Java backend e Spring Boot.

## Tecnologie Utilizzate
- Java 17
- Spring Boot
- Maven
- REST API
- Lombok

## Architettura
Il progetto segue una struttura multilayer:

- **Controller** → gestione richieste HTTP
- **Service** → business logic
- **Repository** → accesso/persistenza dati
- **Entity** → modello dominio

## Endpoint Implementati

### Recupera tutti i veicoli
GET /veicoli

### Filtra per marca
GET /veicoli/marca/{marca}

### Filtra per budget
GET /veicoli/economici?budget=15000

### Aggiungi veicolo
POST /veicoli

Body JSON:
```json
{
  "marca": "BMW",
  "modello": "Serie 3",
  "prezzo": 25000,
  "porte": 5
}
