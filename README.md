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
    ├─ Board.java
    ├─ Move.java
    └─ JsonUtil.java

Wzorce:

Singleton – GameSession (jedna gra).

DTO – Move, Board → to co idzie w JSON.

Observer (wersja prymitywna) – serwer powiadamia dwóch klientów o zmianie plans