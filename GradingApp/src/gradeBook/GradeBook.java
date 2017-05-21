package gradeBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GradeBook {
    int idn, idu, ido, idp;
    char gradeType;

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        DataSearcher dataSearcher = new DataSearcher();
        DataInserter dataInserter = new DataInserter();
        Scanner in = new Scanner(System.in);

        try {
            Connection connection = gradeBook.establishConnection();
            List<Character> gradeTypes = new ArrayList<>();
            gradeTypes = dataSearcher.getGradeTypes();

            System.out.println("Wprowadz kolejno poprawne dane, aby dodac nowa ocene do dziennika. " +
                    "Wpisanie slowa \"koniec\" konczy dzialanie programu.");

            while (true) {
                boolean isTeacherIdValid;
                boolean isStudentIdValid = false;
                boolean isSubjectIdValid = false;
                boolean isGradeIdValid = false;
                boolean isGradeTypeValid = false;

                isTeacherIdValid = gradeBook.getTeacherId(dataSearcher, in, connection);
                if (isTeacherIdValid) {
                    isStudentIdValid = gradeBook.getStudentId(dataSearcher, in, connection);
                }
                if (isStudentIdValid) {
                    isSubjectIdValid = gradeBook.getSubjectId(dataSearcher, in, connection);
                }
                if (isSubjectIdValid) {
                    isGradeIdValid = gradeBook.getGradeId(dataSearcher, in, connection);
                }
                if (isGradeIdValid) {
                    isGradeTypeValid = gradeBook.getTypeOfGrade(in, gradeTypes);
                }
                if (isGradeTypeValid) {
                    dataInserter.addGradingInstance(connection, gradeBook.idu, gradeBook.idn, gradeBook.idp, gradeBook.ido, gradeBook.gradeType);
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

    private boolean getTeacherId(DataSearcher dataSearcher, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id nauczyciela: idn = ");
        boolean recordExists = false;

        if (in.hasNextInt()) {
            idn = in.nextInt();
            recordExists = dataSearcher.doesTeacherExist(connection, idn);
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

    private boolean getStudentId(DataSearcher dataSearcher, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id ucznia: idu = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            idu = in.nextInt();
            recordExists = dataSearcher.doesStudentExist(connection, idu);
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

    private boolean getSubjectId(DataSearcher dataSearcher, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id przedmiotu: idp = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            idp = in.nextInt();
            recordExists = dataSearcher.doesSubjectExist(connection, idp);
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

    private boolean getGradeId(DataSearcher dataSearcher, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id oceny: ido = ");
        boolean recordExists;

//        if (in.nextLine().isEmpty()) {
//            System.out.println("Nie wprowadzono danych.");
//            return false;
//        }

        if (in.hasNextInt()) {
            ido = in.nextInt();
            recordExists = dataSearcher.doesGradeExist(connection, ido);
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

    private boolean getTypeOfGrade(Scanner in, List gradeTypes) {
        System.out.print("Podaj rodzaj oceny (C = cząstkowa, K = koncowa): ");
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
