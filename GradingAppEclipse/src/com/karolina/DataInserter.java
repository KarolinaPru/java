package com.karolina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInserter {

    private final Connection connection;

    public DataInserter(Connection connection) {

        this.connection = connection;
    }

    public void prepareDatabase() {
        createTables();
        fillTablesWithInitialData();
    }

    private void createTables() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(create1);
            statement.execute(create2);
            statement.execute(create3);
            statement.execute(create4);
            statement.execute(create5);
            System.out.println("Stworzono nowe tabele.");

        } catch (SQLException e) {

        }

    }

    private void fillTablesWithInitialData() {
        fillStudentTable();
        fillTeacherTable();
        fillSubjectTable();
        fillGradeTable();
    }

    public boolean addGradingInstance(int studentId, int teacherId, int subjectId, int gradeId, char gradeType) throws SQLException {

        String insertGrade = "INSERT INTO ocenianie VALUES (" + studentId + ", "
                + teacherId + ", " + subjectId + ", " + gradeId + ", " + "'" + Character.toUpperCase(gradeType) + "'" + ")";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertGrade);

            System.out.println("Dodano nowa ocene.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void fillStudentTable() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkRecordsForStudent);
            int numberOfRecords = 0;
            if(resultSet.next()){
                numberOfRecords = resultSet.getInt(1);
            }
            if(numberOfRecords == 0) {
                statement.executeUpdate(insertStudent1);
                statement.executeUpdate(insertStudent2);
                statement.executeUpdate(insertStudent3);
                statement.executeUpdate(insertStudent4);
                statement.executeUpdate(insertStudent5);
                statement.executeUpdate(insertStudent6);
                statement.executeUpdate(insertStudent7);
                statement.executeUpdate(insertStudent8);
                statement.executeUpdate(insertStudent9);
                statement.executeUpdate(insertStudent10);
                System.out.println("Dodano dane do tabeli Uczen.");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillTeacherTable() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkRecordsForTeacher);
            int numberOfRecords = 0;
            if(resultSet.next()){
                numberOfRecords = resultSet.getInt(1);
            }
            if(numberOfRecords == 0) {
                statement.executeUpdate(insertTeacher1);
                statement.executeUpdate(insertTeacher2);
                statement.executeUpdate(insertTeacher3);
                statement.executeUpdate(insertTeacher4);
                statement.executeUpdate(insertTeacher5);
                System.out.println("Dodano dane do tabeli Nauczyciel.");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillSubjectTable() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkRecordsForSubject);
            int numberOfRecords = 0;
            if(resultSet.next()){
                numberOfRecords = resultSet.getInt(1);
            }
            if(numberOfRecords == 0) {
                statement.executeUpdate(insertSubject1);
                statement.executeUpdate(insertSubject2);
                statement.executeUpdate(insertSubject3);
                statement.executeUpdate(insertSubject4);
                statement.executeUpdate(insertSubject5);
                statement.executeUpdate(insertSubject6);
                statement.executeUpdate(insertSubject7);
                System.out.println("Dodano dane do tabeli Przedmiot.");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillGradeTable() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkRecordsForGrade);
            int numberOfRecords = 0;
            if(resultSet.next()){
                numberOfRecords = resultSet.getInt(1);
            }
            if(numberOfRecords == 0) {
                statement.executeUpdate(insertGrade1);
                statement.executeUpdate(insertGrade2);
                statement.executeUpdate(insertGrade3);
                statement.executeUpdate(insertGrade4);
                statement.executeUpdate(insertGrade5);
                statement.executeUpdate(insertGrade6);
                System.out.println("Dodano dane do tabeli Ocena.");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private final String create1 = "CREATE TABLE uczen (idu INTEGER NOT NULL, nazwisko_ucznia VARCHAR (30) NOT NULL, imie_ucznia VARCHAR (20) NOT NULL)";
    private final String create2 = "CREATE TABLE nauczyciel (idn INTEGER NOT NULL, nazwisko_nauczyciela VARCHAR (30) NOT NULL, imie_nauczyciela VARCHAR (20) NOT NULL)";
    private final String create3 = "CREATE TABLE przedmiot (idp INTEGER NOT NULL, nazwa_przedmiotu VARCHAR (20) NOT NULL)";
    private final String create4 = "CREATE TABLE ocena (ido INTEGER NOT NULL, wartosc_opisowa VARCHAR (20) NOT NULL, wartosc_numeryczna FLOAT NOT NULL)";
    private final String create5 = "CREATE TABLE ocenianie (idu INTEGER NOT NULL, idn INTEGER NOT NULL, idp INTEGER NOT NULL, ido INTEGER NOT NULL, rodzaj_oceny CHAR (1) NOT NULL)";

    private final String checkRecordsForStudent = "select count(1) from uczen";
    private final String insertStudent1 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (1, 'Adamski', 'Jan')";
    private final String insertStudent2 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (2, 'Bartecka', 'Joanna')";
    private final String insertStudent3 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (3, 'Czartoryska', 'Ewa')";
    private final String insertStudent4 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (4, 'Darecki', 'Krzysztof')";
    private final String insertStudent5 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (5, 'Ermanowski', 'Mateusz')";
    private final String insertStudent6 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (6, 'Filipkowska', 'Erwina')";
    private final String insertStudent7 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (7, 'Grecki', 'Bartlomiej')";
    private final String insertStudent8 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (8, 'Halicka', 'Hanna')";
    private final String insertStudent9 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (9, 'Iwanski', 'Tomasz')";
    private final String insertStudent10 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (10, 'Jackowska', 'Katarzyna')";

    private final String checkRecordsForTeacher = "select count(1) from NAUCZYCIEL";
    private final String insertTeacher1 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (1, 'Bartecka', 'Krystyna')";
    private final String insertTeacher2 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (2, 'Chojnicki', 'Aleksander')";
    private final String insertTeacher3 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (3, 'Zawistowska', 'Ewa')";
    private final String insertTeacher4 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (4, 'Lis', 'Matylda')";
    private final String insertTeacher5 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (5, 'Malinowska', 'Anna')";


    private final String checkRecordsForSubject = "select count(1) from przedmiot";
    private final String insertSubject1 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (1, 'matematyka')";
    private final String insertSubject2 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (2, 'fizyka')";
    private final String insertSubject3 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (3, 'historia')";
    private final String insertSubject4 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (4, 'jezyk angielski')";
    private final String insertSubject5 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (5, 'jezyk polski')";
    private final String insertSubject6 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (6, 'biologia')";
    private final String insertSubject7 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (7, 'chemia')";


    private final String checkRecordsForGrade = "select count(1) from ocena";
    private final String insertGrade1 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (1, 'celujacy', 6)";
    private final String insertGrade2 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (2, 'bardzo dobry', 5)";
    private final String insertGrade3 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (3, 'dobry', 4)";
    private final String insertGrade4 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (4, 'dostateczny', 3)";
    private final String insertGrade5 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (5, 'dopuszczajacy', 2)";
    private final String insertGrade6 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (6, 'niedopuszczajacy', 1)";
}
