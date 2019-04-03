# clients
A service that manages clients contacts

## Installation

To start the application go to parent directory and execute `./gradlew :bootRun`, that will start the application on localhost:8080.

## Usage

### Add contacts
To add new sample contact POST the following JSON to `http://localhost:8080/client/{clientId}`:
```
{
        "id": 1,
        "clientId": 1,
        "firstName": "Name",
        "lastName": "Lastname",
        "company": "Company",
        "address": "Street - 1",
        "phone": "3701234567",
        "birthday": "2000-01-01"
}
```

### Get contacts
To get contacts of a client GET from `http://localhost:8080/client/{clientId}?sortByColumn=lastname&sortingOrder=DESC`, where request parameters are: 
1. `sortByColumn` sorts contacts by specified column: firstName, lastName, company, address, phone, birthday
1. `sortingOrder` sets sorting order
