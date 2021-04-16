# HTW | Übung: GitHub Actions mit Maven und JUnit Tests

Das Repository enthält ein Übungsprojekt für die Praktikumsaufgabe zu **GitHub Actions** [Teil 8 - Aufgabe 2 - JUnit-Tests](https://www.informatik.htw-dresden.de/~zirkelba/praktika/se/arbeiten-mit-git-und-asciidoc/praktikumsaufgaben-teil-8.html##_aufgabe_2_junit_tests) im Fach Software Engineering II.

Es ist eine simple Java-Anwendung, bestehend aus einer `Town`- und `TestTown`-Klasse und ist dem Praktikum zu **UnitTest mit Java** entnommen.

### Projektstruktur:

```
README.md
pom.xml
src
├── main
│   └── java
│       └── example
│           └── Town.java
└── test
    └── java
        └── example
            └── TestTown.java
```

### Dateien:

Datei           | Beschreibung
--------------- | ------------
`README.md`     | Beschreibung des Repository im MarkDown-Format
`pom.xml`       | Beschreibung des Maven-Projektes im XML-Format
`Town.java`     | Klasse `Town` für eine Stadt mit Name (`name`) und Einwohneranzahl (`residents`) und zugehörigen Methoden
`TestTown.java` | Klasse `TestTown` mit JUnit-Tests zum Testen der `Town`-Klasse

### Hinweise zu GitHub Actions

Nach Bearbeitung der Aufgaben liegen im Verzeichnis `.github/workflows/` die zum Projekt gehörigen Workflows.

### Hinweise zu Maven

Für eine lokale Ausführung der Tests mit Maven wird eine [Maven Installation](https://maven.apache.org/) benötigt (für das Praktikum nicht notwendig).

Folgend ein paar hilfreiche Kommandos:

- Bereinigt die von Maven während des Builds generierten Dateien und Verzeichnisse (bspw. das *target*-Verzeichnis):
    ```
    % mvn clean
    ```

- Führt alle oder ausgewählte Test-Klassen aus:
    ```
    % mvn test
    $ mvn clean test
    % mvn -Dtest=TestTown test
    ```

- Kompiliert und Erstellt ein Paket (bspw. JAR-Datei) aus den Quellcodedateien:
    ```
    % mvn package
    ```

- Ausführen der erstellten JAR-Datei:
    ```
    % java -cp target/example-1.0-SNAPSHOT.jar example.Town
    ```
