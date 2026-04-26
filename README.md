# Programowanie Współbieżne - Laboratorium

Projekt stworzony na potrzeby laboratoriów z przedmiotu Programowanie Współbieżne. Celem programu jest porównanie wydajności i poprawności różnych metod inkrementacji licznika w środowisku wielowątkowym.

## Opis projektu

Program wykonuje symulacje inkrementacji licznika przez wiele wątków jednocześnie. Porównuje trzy główne implementacje licznika:

1.  **UnsafeCounter**: Implementacja bez żadnej synchronizacji. Służy do demonstracji problemu wyścigów (race conditions) – w środowisku wielowątkowym końcowa wartość licznika zazwyczaj nie zgadza się z oczekiwaną.
2.  **SynchronizedCounter**: Implementacja wykorzystująca słowo kluczowe `synchronized` do blokowania dostępu do sekcji krytycznej. Gwarantuje poprawność, ale narzuca narzut związany z blokowaniem.
3.  **AtomicCounter**: Implementacja oparta na klasach z pakietu `java.util.concurrent.atomic` (np. `AtomicInteger`), wykorzystująca niskopoziomowe operacje CAS (Compare-and-Swap). Zapewnia poprawność i zazwyczaj lepszą skalowalność niż tradycyjna synchronizacja.

## Parametry Benchmarku

Program przeprowadza testy (benchmarki) dla różnych scenariuszy:
-   **Liczba wątków**: Testowane są różne warianty obciążenia (np. 8 wątków lub maksymalna liczba wątków fizycznych procesora - 24).
-   **Liczba operacji**: Każdy wątek wykonuje określoną liczbę inkrementacji (od 10 do 1 000 000).
-   **Weryfikacja**: Program sprawdza, czy końcowa wartość licznika jest poprawna i mierzy czas wykonania w nanosekundach.

## Wyniki

Wyniki benchmarków są wypisywane na konsolę oraz mogą być zapisywane do plików `.csv` w celu dalszej analizy (np. generowania wykresów).

## Technologia

-   **Język**: Java
-   **Zarządzanie projektem**: Maven
-   **Główna klasa**: `com.pawer.Main`
