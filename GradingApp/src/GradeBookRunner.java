import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GradeBookRunner {
     Scanner in;
     List<Character> gradeTypes = new ArrayList<>();
     List<String> gradeDescriptions = new ArrayList<>();
     List<Integer> grades = new ArrayList<>();


    public static void main(String[] args) {
    GradeBookRunner runner = new GradeBookRunner();
    GradeBook gradeBook = new GradeBook();

        try {
            Connection connection = runner.establishConnection();
            runner.gradeTypes = gradeBook.getGradeTypes();
            runner.gradeDescriptions = gradeBook.getGradeDescriptions(connection);
            runner.gradeDescriptions = gradeBook.getGradeDescriptions(connection);
            runner.grades = gradeBook.getGrades(connection);




            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
