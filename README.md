# E-biznes

**Zadanie 1 Docker**

✅  3.0 obraz ubuntu z Pythonem w wersji 3.8

✅  3.5 obraz ubuntu:22.04 z Javą w wersji 8 oraz Kotlinem

✅  4.0 do powyższego należy dodać najnowszego Gradle’a oraz paczkę JDBC SQLite w ramach projektu na Gradle (build.gradle)

✅ 4.5 stworzyć przykład typu HelloWorld oraz uruchomienie aplikacji przez CMD oraz gradle

✅  5.0 dodać konfigurację docker-compose


Kod: https://github.com/w757/E-biznes/tree/main/Zadanie%201%20-%20Docker

Demo: https://drive.google.com/file/d/1W7h3DLzefbYcCgquvT--Xw-_n-OsAsGs/view?usp=sharing




**Zadanie 2 Scala**

✅ 3.0 Należy stworzyć kontroler do Produktów

✅ 3.5 Do kontrolera należy stworzyć endpointy zgodnie z CRUD - dane pobierane z listy

✅ 4.0 Należy stworzyć kontrolery do Kategorii oraz Koszyka + endpointy zgodnie z CRUD

4.5 Należy aplikację uruchomić na dockerze (stworzyć obraz) oraz dodać skrypt uruchamiający aplikację via ngrok

5.0 Należy dodać konfigurację CORS dla dwóch hostów dla metod CRUD


Kod: https://github.com/w757/E-biznes/tree/main/Zadanie%202%20-%20Scala

Demo: https://drive.google.com/file/d/15Ohl21Zu2iHtpTx_Wr8Gl0wvVsuSCFPp/view?usp=sharing




**Zadanie 3 Kotlin** 

✅ 3.0 Należy stworzyć aplikację kliencką w Kotlinie we frameworku Ktor, która pozwala na przesyłanie wiadomości na platformę Discord

✅ 3.5 Aplikacja jest w stanie odbierać wiadomości użytkowników z platformy Discord skierowane do aplikacji (bota)

✅ 4.0 Zwróci listę kategorii na określone żądanie użytkownika

4.5 Zwróci listę produktów wg żądanej kategorii

5.0 Aplikacja obsłuży dodatkowo jedną z platform: Slack, Messenfer, Webex, Skype, Discrod


Kod: https://github.com/w757/E-biznes/tree/main/Zadanie%203%20-%20Kotlin

Demo: https://drive.google.com/file/d/1WU9yu9PAGy_JlGWl1PoMRWFglpT9q4GV/view?usp=sharing




**Zadanie 4 Go**

✅ 3.0 Należy stworzyć aplikację we frameworki echo w j. Go, która będzie miała kontroler Produktów zgodny z CRUD

✅ 3.5 Należy stworzyć model Produktów wykorzystując gorm oraz wykorzystać model do obsługi produktów (CRUD) w kontrolerze (zamiast listy)

✅ 4.0 Należy dodać model Koszyka oraz dodać odpowiedni endpoint

✅ 4.5 Należy stworzyć model kategorii i dodać relację między kategorią, a produktem

✅ 5.0 pogrupować zapytania w gorm’owe scope'y

Demo: https://drive.google.com/file/d/1hxPz_ucDoO4EgyuW85BxbNKlxUPZ-xU4/view?usp=sharing

Kod: https://github.com/w757/E-biznes/tree/main/Zadanie%204%20-%20Go





**Zadanie 5 Frontend**

Należy stworzyć aplikację kliencką wykorzystując bibliotekę React.js. W ramach projektu należy stworzyć trzy komponenty: Produkty, Koszyk oraz Płatności. Koszyk oraz Płatności powinny wysyłać do aplikacji serwerowej dane, a w Produktach powinniśmy pobierać dane o produktach z aplikacji serwerowej. Aplikacja serwera w jednym z trzech języków: Kotlin, Scala, Go. Dane pomiędzy wszystkimi komponentami powinny być przesyłane za pomocą React hooks.

✅3.0 W ramach projektu należy stworzyć dwa komponenty: Produkty oraz Płatności; Płatności powinny wysyłać do aplikacji serwerowej dane, a w Produktach powinniśmy pobierać dane o produktach z aplikacji serwerowej ; 3.5 Należy dodać Koszyk wraz z widokiem; należy wykorzystać routing

✅ 4.0 Dane pomiędzy wszystkimi komponentami powinny być przesyłane za pomocą React hooks

✅ 4.5 Należy dodać skrypt uruchamiający aplikację serwerową oraz kliencką na dockerze via docker-compose

✅ 5.0 Należy wykorzystać axios’a oraz dodać nagłówki pod CORS


Demo: https://drive.google.com/file/d/1NT57_Bn-T6qCIE0xoII6iYyqSqQ19CXm/view?usp=sharing

Kod: https://github.com/w757/E-biznes/tree/main/Zadanie%205%20-%20Frontend



**Zadanie 6 Testy**

Należy stworzyć 20 przypadków testowych w jednym z rozwiązań:

Cypress JS (JS)
Selenium (Kotlin, Python, Java, JS, Go, Scala)
Testy mają w sumie zawierać minimum 50 asercji (3.5). Mają również uruchamiać się na platformie Browserstack (5.0). Proszę pamiętać o stworzeniu darmowego konta via https://education.github.com/pack.

3.0 Należy stworzyć 20 przypadków testowych w CypressJS lub Selenium (Kotlin, Python, Java, JS, Go, Scala)

3.5 Należy rozszerzyć testy funkcjonalne, aby zawierały minimum 50 asercji

4.0 Należy stworzyć testy jednostkowe do wybranego wcześniejszego projektu z minimum 50 asercjami

4.5 Należy dodać testy API, należy pokryć wszystkie endpointy z minimum jednym scenariuszem negatywnym per endpoint

5.0 Należy uruchomić testy funkcjonalne na Browserstacku

Studian dzienne:

Termin gr.1:

Termin gr.2:

Studia zaoczne:
