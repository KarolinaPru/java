package com.karolina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GradeBook {

    private DataSearcher dataSearcher;

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.run();
    }

    int idn, idu, ido, idp;
    char gradeType;

    private final Scanner in = new Scanner(System.in);

    public void run() {

        try {
            Connection connection = establishConnection();
            DataInserter dataInserter = new DataInserter(connection);
            dataInserter.prepareDatabase();
            dataSearcher = new DataSearcher(connection);

            List<Character> gradeTypes = dataSearcher.getGradeTypes();

            System.out.println("Wprowadz kolejno poprawne dane, aby dodac nowa ocene do dziennika. " +
                    "Wpisanie slowa \"koniec\" konczy dzialanie programu.");

            while (true) {
                boolean isTeacherIdValid;
                boolean isStudentIdValid = false;
                boolean isSubjectIdValid = false;
                boolean isGradeIdValid = false;
                boolean isGradeTypeValid = false;

                isTeacherIdValid = getTeacherId();
                if (isTeacherIdValid) {
                    isStudentIdValid = getStudentId();
                }
                if (isStudentIdValid) {
                    isSubjectIdValid = getSubjectId();
                }
                if (isSubjectIdValid) {
                    isGradeIdValid = getGradeId();
                }
                if (isGradeIdValid) {
                    isGradeTypeValid = getTypeOfGrade(gradeTypes);
                }
                if (isGradeTypeValid) {
                    dataInserter.addGradingInstance(idu, idn, idp, ido, gradeType);
                }

                if(in.nextLine().equals("koniec".toLowerCase())) {
                    System.out.println("Koniec dzialania programu.");
                    break;
                }
            }
            in.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean getTeacherId() throws SQLException {
        System.out.print("Podaj id nauczyciela: idn = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            idn = in.nextInt();
            recordExists = dataSearcher.doesTeacherExist(idn);
            if (recordExists == false) {
                System.out.println("Nauczyciel o podanym ID nie istnieje.");
                return recordExists;
            }
        } else {
            System.out.println("Wprowadzono nieprawidlowe dane.");
            return false;
        }

        return recordExists;
    }

    private boolean getStudentId() throws SQLException {
        System.out.print("Podaj id ucznia: idu = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            idu = in.nextInt();
            recordExists = dataSearcher.doesStudentExist(idu);
            if (recordExists == false) {
                System.out.println("Uczen o podanym ID nie istnieje.");
                return recordExists;
            }
        } else {
            System.out.println("Wprowadzono nieprawidlowe dane.");
            return false;
        }
        return recordExists;
    }

    private boolean getSubjectId() throws SQLException {
        System.out.print("Podaj id przedmiotu: idp = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            idp = in.nextInt();
            recordExists = dataSearcher.doesSubjectExist(idp);
            if (recordExists == false) {
                System.out.println("Przedmiot o podanym ID nie istnieje.");
                return recordExists;
            }
        } else {
            System.out.println("Wprowadzono nieprawidlowe dane.");
            return false;
        }
        return recordExists;
    }

    private boolean getGradeId() throws SQLException {
        System.out.print("Podaj id oceny: ido = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            ido = in.nextInt();
            recordExists = dataSearcher.doesGradeExist(ido);
            if (recordExists == false) {
                System.out.println("Ocena o podanym ID nie istnieje.");
                return recordExists;
            }
        } else {
            System.out.println("Wprowadzono nieprawidlowe dane.");
            return false;
        }
        return recordExists;
    }

    private boolean getTypeOfGrade(List gradeTypes) {
        System.out.print("Podaj rodzaj oceny (C = czastkowa, K = koncowa): ");
        boolean isValueValid;

        if (in.hasNext()) {
            gradeType = in.next().charAt(0);
            isValueValid = gradeTypes.contains(Character.toUpperCase(gradeType));

            if (isValueValid) {
                System.out.println("Wartosc poprawna");
            } else {
                System.out.println("Podany rodzaj oceny nie istnieje.");
            }
            return isValueValid;

        } else {
            System.out.println("Wprowadzono nieprawidlowe dane.");
            return false;
        }
    }

    private Connection establishConnection() {
        try {
            String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
            String username = "xkprusac";
            String password = "xkprusac";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Nawiazano polaczenie.");
            return connection;

        } catch (SQLException e) {
            System.out.println("Nie udalo sie nawiazac polaczenia.");
            return null;
        }
    }
}
