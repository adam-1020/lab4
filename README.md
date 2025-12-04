lab4

src/

├─ client/

│    ├─ ClientMain.java

│    └─ ClientConnection.java

├─ server/

│    ├─ ServerMain.java

│    ├─ ClientHandler.java

│    └─ GameSession.java

└─ common/

│    ├─ Board.java

│    ├─ Move.java

│    └─ JsonUtil.java

Wzorce:

Singleton – GameSession (jedna gra).

DTO – Move, Board → to co idzie w JSON.

Observer (wersja prymitywna) – serwer powiadamia dwóch klientów o zmianie plans

Instrukcja:

javac .\lab4\client\*.java

java lab4.client.ClientMain

Opis:

plansza 19×19,

Singleton: GameSession (jedna gra),

DTO: Move, Board (wysyłane w JSON),

Observer (prymitywny): GameSession powiadamia ClientHandler o zmianach planszy,

PASS (pominięcie ruchu),

RESIGN (poddanie się),

zdejmowanie (capturing) grup przeciwnika,

blokada ruchu samobójczego (suicide),

blokada KO (zabronione natychmiastowe powtórzenie pozycji — porównanie z pozycją sprzed ostatniego ruchu),

interfejs konsolowy, który pokazuje planszę i komunikaty,

obsługa błędów i rozłączeń,

dokładnie 2 graczy.

Dodatkowo:

KO: implementacja zabrania natychmiastowego powrotu do pozycji sprzed ostatniego ruchu (porównanie aktualnej planszy do previousBoard). To blokuje klasyczny cykliczny Ko.

Suicide: zabroniony — jeśli postawienie kamienia nie daje libertów i nie zabiera przeciwnika -> odrzucamy.

Capture: zadziała dla otoczonych grup (rekursywnie / stack).

Po 2x PASS gra się kończy (GAME_OVER Both players passed). Nie zaimplementowałem automatycznego liczenia punktów — mogę dodać (japońskie/chińskie) jeśli chcesz.

Obsługa błędów: serwer odsyła ERROR ... klientowi; po rozłączeniu przeciwnika gra kończy się i drugi gracz dostaje ERROR Opponent disconnected oraz GAME_OVER ....

Serwer akceptuje dokładnie 2 połączenia i potem uruchamia grę.