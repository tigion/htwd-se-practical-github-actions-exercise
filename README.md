# HTWD | Übung: GitHub Actions mit Unit-Tests

Das Repository enthält Übungsprojekte für die Praktikumsaufgabe zu
**GitHub Actions** [Teil 10 - Aufgabe 2 - Unit-Tests] im Fach
Software Engineering II.

[Teil 10 - Aufgabe 2 - Unit-Tests]: https://www.informatik.htw-dresden.de/~zirkelba/praktika/se/arbeiten-mit-git-und-asciidoc/praktikumsaufgaben-teil-10.html#_aufgabe_2_unit_tests

Enthalten ist jeweils eine simple Anwendung in _Java_ ([Maven], [JUnit]) und
_Python_ ([unittest]), bestehend aus einer `Town`- und `TestTown`-Klasse.
Diese sind dem Praktikum zu **Unit-Test mit Java und Python** entnommen.

[Maven]: https://maven.apache.org/
[JUnit]: https://junit.org/junit5/docs/current/user-guide/
[unittest]: https://docs.python.org/3/library/unittest.html#

> [!WARNING]
> Ein Test schlägt bewusst fehl, da dieser
> im Zuge der Aufgabenbearbeitung mit angepasst wird.

## Hinweise

Es liegt jeweils ein Beispielprojekte in **Java** und in **Python** vor:

```txt
├── example-java
└── example-python
```

Für jedes Projekt werden im Laufe der Bearbeitung der Aufgaben die zugehörigen
**GitHub Action Workflows** im Verzeichnis `.github/workflows/` abgelegt.

## Example Java

### Projektstruktur

```txt
example-java
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── example
    │           ├── Main.java
    │           └── Town.java
    └── test
        └── java
            └── example
                ├── TestMain.java
                └── TestTown.java
```

| Datei           | Beschreibung                                                                                              |
| --------------- | --------------------------------------------------------------------------------------------------------- |
| `pom.xml`       | Beschreibung des Maven-Projektes im XML-Format                                                            |
| `Main.java`     | Klasse `Main` für die `main()` Methode                                                                    |
| `Town.java`     | Klasse `Town` für eine Stadt mit Name (`name`) und Einwohneranzahl (`residents`) und zugehörigen Methoden |
| `TestMain.java` | Klasse `TestMain` mit beispielhaften Unit-Tests zum Testen der `Main`-Klasse                              |
| `TestTown.java` | Klasse `TestTown` mit beispielhaften Unit-Tests zum Testen der `Town`-Klasse                              |

### Hinweise zu Java mit Maven

Für eine lokale Ausführung der Tests mit Maven wird eine [Maven Installation](https://maven.apache.org/)
benötigt (für das Praktikum nicht notwendig).

Folgend ein paar hilfreiche Kommandos (vorher ggf. `cd example-java`):

- Version anzeigen:

  ```shell
  % mvn --version
  ```

- Bereinigt die von Maven während des Builds generierten Dateien und
  Verzeichnisse (bspw. das _target_-Verzeichnis):

  ```shell
  % mvn clean
  ```

- Führt alle oder ausgewählte Test-Klassen aus:

  ```shell
  % mvn test
  $ mvn clean test
  % mvn -Dtest=TestTown test
  ```

- Kompiliert und Erstellt ein Paket (bspw. JAR-Datei) aus den Quellcodedateien:

  ```shell
  % mvn package
  ```

- Ausführen der erstellten JAR-Datei:

  ```shell
  % java -cp target/example-1.0-SNAPSHOT.jar example.Main
  The town Dresden has 556780 residents.
  Town('Dresden', 556780)
  Dresden
  -1
  ```

## Example Python

### Projektstruktur

```txt
example-python
├── main
│   ├── __init__.py
│   ├── main.py
│   └── town.py
└── tests
    ├── __init__.py
    └── test_town.py
```

| Datei          | Beschreibung                                                                                              |
| -------------- | --------------------------------------------------------------------------------------------------------- |
| `__init__.py`  | Markiert das Verzeichnis als Paket (regular package) mit zugehörigem Namensraum (namespace)               |
| `main.py`      | Klasse `Main` für die `main()` Methode                                                                    |
| `town.py`      | Klasse `Town` für eine Stadt mit Name (`name`) und Einwohneranzahl (`residents`) und zugehörigen Methoden |
| `test_town.py` | Klasse `TestTown` mit beispielhaften Unit-Tests zum Testen der `Town`-Klasse                              |

### Hinweise zu Python mit Unittest

Folgend ein paar hilfreiche Kommandos (vorher ggf. `cd example-python`):

- Version anzeigen:

  ```shell
  % python3 --version
  ```

- Führt ausgewählte Tests, Test-Klassen/-Methoden aus:

  ```shell
  % python3 -m unittest tests.test_town
  % python3 -m unittest tests.test_town.TestTown
  % python3 -m unittest tests.test_town.TestTown.testTownValues
  ```

- Führt Tests aller oder ausgewählter Pakete/Dateien aus:

  ```shell
  % python3 -m unittest discover
  % python3 -m unittest discover tests
  % python3 -m unittest discover tests "test_*.py"
  ```

- Ausführen mit:

  ```shell
  % python3 main/main.py
  The town Dresden has 556780 residents.
  Town('Dresden', 556780)
  Dresden
  -1
  ```
