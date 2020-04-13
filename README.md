#  Aplikacja pobierająca kursy kryptowalut i umożliwiającą ich wymianę

## Opis aplikacji 
Aplikacja udostępnia endpointy, pod które można wysyłać żądania, a odpowiedzi są zwracane w formacie JSON.
Aplikacja korzysta z api z strony  https://www.coinapi.io/ .
##### Endpointy
* GET /currencies/{currency}/all - zwracający cała listę notowań dla podanej kryptowaluty
* GET /currencies/{currency}?filter= - filter ograniczający listę notowań.
* POST /currencies/exchange - Umożliwić kalkulację wymiany kryptowaluty A na B, w podanej ilości po aktualnym kursie

## Wymagania:
* Java 14
* Gradle 7.0
* InteliJ IDEA 

