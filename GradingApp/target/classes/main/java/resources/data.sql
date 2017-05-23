CREATE TABLE uczen (idu INTEGER NOT NULL, nazwisko_ucznia VARCHAR (30) NOT NULL, imie_ucznia VARCHAR (20) NOT NULL);
CREATE TABLE nauczyciel (idn INTEGER NOT NULL, nazwisko_nauczyciela VARCHAR (30) NOT NULL, imie_nauczyciela VARCHAR (20) NOT NULL);
CREATE TABLE przedmiot (idp INTEGER NOT NULL, nazwa_przedmiotu VARCHAR (20) NOT NULL);
CREATE TABLE ocena (ido INTEGER NOT NULL, wartosc_opisowa VARCHAR (20) NOT NULL, wartosc_numeryczna FLOAT NOT NULL);
CREATE TABLE ocenianie (idu INTEGER NOT NULL, idn INTEGER NOT NULL, idp INTEGER NOT NULL, ido INTEGER NOT NULL, rodzaj_oceny CHAR (1) NOT NULL);

INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (1, 'Adamski', 'Jan');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (2, 'Bartecka', 'Joanna');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (3, 'Czartoryska', 'Ewa');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (4, 'Darecki', 'Krzysztof');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (5, 'Ermanowski', 'Mateusz');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (6, 'Filipkowska', 'Erwina');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (7, 'Grecki', 'Bartlomiej');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (8, 'Halicka', 'Hanna');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (9, 'Iwanski', 'Tomasz');
INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (10, 'Jackowska', 'Katarzyna');

INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (1, 'Bartecka', 'Krystyna');
INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (2, 'Chojnicki', 'Aleksander');
INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (3, 'Zawistowska', 'Ewa');
INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (4, 'Lis', 'Matylda');
INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (5, 'Malinowska', 'Anna');

INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (1, 'matematyka');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (2, 'fizyka');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (3, 'historia');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (4, 'jezyk angielski');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (5, 'jezyk polski');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (6, 'biologia');
INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (7, 'chemia');

INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (1, 'celujacy', 6);
INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (2, 'bardzo dobry', 5);
INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (3, 'dobry', 4);
INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (4, 'dostateczny', 3);
INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (5, 'dopuszczajacy', 2);
INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (6, 'niedopuszczajacy', 1);

