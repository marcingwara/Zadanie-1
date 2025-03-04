## Zadanie Zaliczeniowe 1 - Selenium WebDriver + Cucumber

### Opis
Ten skrypt automatyzuje proces logowania i zarządzania adresami użytkownika w sklepie internetowym PrestaShop.

### Kroki testowe:
1. Utwórz użytkownika manualnie na stronie [MyStore TestLab](https://mystore-testlab.coderslab.pl) (możesz użyć tymczasowego maila z [10 Minute Mail](https://10minutemail.com/)).
2. Zaloguj się na utworzone konto użytkownika.
3. Przejdź do sekcji „Addresses” po zalogowaniu (adres: [link](https://mystore-testlab.coderslab.pl/index.php?controller=addresses)).
4. Kliknij przycisk „Create new address”.
5. Wypełnij formularz „New address” danymi z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone).
6. Sprawdź, czy dane w dodanym adresie są poprawne.

### Dodatkowe kroki dla chętnych:
1. Usuń dodany adres klikając „Delete”.
2. Sprawdź, czy adres został poprawnie usunięty.

### Wymagania:
- JAVA + Selenium + Cucumber
- Przeglądarka Chrome + WebDriver
- Konto użytkownika w PrestaShop
