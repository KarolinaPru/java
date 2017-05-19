import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GradeBookRunner {

    public static void main(String[] args) {
        GradeBookRunner runner = new GradeBookRunner();
        GradeBook gradeBook = new GradeBook();
        Scanner in = new Scanner(System.in);

        try {
            Connection connection = runner.establishConnection();
            List<Character> gradeTypes = new ArrayList<>();
            gradeTypes = gradeBook.getGradeTypes();

            boolean isTeacherIdValid;
            boolean isStudentIdValid = false;
            boolean isSubjectIdValid = false;
            boolean isGradeIdValid = false;
            boolean isGradeTypeValid;

            isTeacherIdValid = getTeacherId(gradeBook, in, connection);
            if (isTeacherIdValid) {
                isStudentIdValid = getStudentId(gradeBook, in, connection);
            }
            if (isStudentIdValid) {
                isSubjectIdValid = getSubjectId(gradeBook, in, connection);
            }
            if (isSubjectIdValid) {
                isGradeIdValid = getGradeId(gradeBook, in, connection);
            }
            if (isGradeIdValid) {
                isGradeTypeValid = getTypeOfGrade(in, gradeTypes);
            }

            in.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static boolean getTeacherId(GradeBook gradeBook, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id nauczyciela: idn = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            int idn = in.nextInt();
            recordExists = gradeBook.doesTeacherExist(connection, idn);
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

    private static boolean getStudentId(GradeBook gradeBook, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id ucznia: idu = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            int idu = in.nextInt();
            recordExists = gradeBook.doesStudentExist(connection, idu);
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

    private static boolean getSubjectId(GradeBook gradeBook, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id przedmiotu: idp = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            int idp = in.nextInt();
            recordExists = gradeBook.doesSubjectExist(connection, idp);
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

    private static boolean getGradeId(GradeBook gradeBook, Scanner in, Connection connection) throws SQLException {
        System.out.print("Podaj id oceny: ido = ");
        boolean recordExists;

        if (in.hasNextInt()) {
            int ido = in.nextInt();
            recordExists = gradeBook.doesGradeExist(connection, ido);
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

    private static boolean getTypeOfGrade (Scanner in, List gradeTypes) {
        System.out.print("Podaj rodzaj oceny (C = cząstkowa, K = koncowa): ");
        boolean isValueValid;

        if (in.hasNext()) {
            char  gradeType = in.next().charAt(0);
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

    private Connection establishConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
        String username = "xkprusac";
        String password = "xkprusac";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully.");
        return connection;
    }
}
