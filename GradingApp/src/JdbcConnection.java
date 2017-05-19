import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static void main (String[] args) {

        try {
            String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
            String username = "xkprusac";
            String password = "xkprusac";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection was not established.");
        }

        System.out.println("Success");
    }

}