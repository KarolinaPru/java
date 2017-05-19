CREATE TABLE uczen (idu INTEGER NOT NULL, nazwisko_ucznia VARCHAR (30) NOT NULL, imie_ucznia VARCHAR (20) NOT NULL);
CREATE TABLE nauczyciel (idn INTEGER NOT NULL, nazwisko_nauczyciela VARCHAR (30), imie_nauczyciela VARCHAR (20));
CREATE TABLE przedmiot (idp INTEGER NOT NULL, nazwa_przedmiotu VARCHAR (20) NOT NULL);
CREATE TABLE ocena (ido INTEGER NOT NULL, wartosc_opisowa VARCHAR (20) NOT NULL, wartosc_numeryczna FLOAT NOT NULL);
CREATE TABLE ocenianie (idu INTEGER NOT NULL, idn INTEGER NOT NULL, idp INTEGER NOT NULL, ido INTEGER NOT NULL, rodzaj_oceny CHAR (1));

INSERT INTO uczen VALUES (1, "Adamski", "Jan");
INSERT INTO uczen VALUES (2, "Bartecka", "Joanna");
INSERT INTO uczen VALUES (3, "Czartoryska", "Ewa");
INSERT INTO uczen VALUES (4, "Darecki", "Krzysztof");
INSERT INTO uczen VALUES (5, "Ermanowski", "Mateusz");
INSERT INTO uczen VALUES (6, "Filipkowska", "Erwina");
INSERT INTO uczen VALUES (7, "Grecki", "Bartlomiej");
INSERT INTO uczen VALUES (8, "Halicka", "Hanna");
INSERT INTO uczen VALUES (9, "Iwanski", "Tomasz");
INSERT INTO uczen VALUES (10, "Jackowska", "Katarzyna");

INSERT INTO nauczyciel VALUES (1, "Bartecka", "Krystyna");
INSERT INTO nauczyciel VALUES (2, "Chojnicki", "Aleksander");
INSERT INTO nauczyciel VALUES (3, "Zawistowska", "Ewa");
INSERT INTO nauczyciel VALUES (4, "Lis", "Matylda");
INSERT INTO nauczyciel VALUES (5, "Malinowska", "Anna");

INSERT INTO przedmiot VALUES (1, "matematyka");
INSERT INTO przedmiot VALUES (2, "fizyka");
INSERT INTO przedmiot VALUES (3, "historia");
INSERT INTO przedmiot VALUES (4, "jezyk angielski");
INSERT INTO przedmiot VALUES (5, "jezyk polski");
INSERT INTO przedmiot VALUES (6, "biologia");
INSERT INTO przedmiot VALUES (7, "chemia");

INSERT INTO ocena VALUES (1, "celujacy", 6);
INSERT INTO ocena VALUES (2, "bardzo dobry", 5);
INSERT INTO ocena VALUES (3, "dobry", 4);
INSERT INTO ocena VALUES (4, "dostateczny", 3);
INSERT INTO ocena VALUES (5, "dopuszczajacy", 2);
INSERT INTO ocena VALUES (6, "niedopuszczajacy", 1);

