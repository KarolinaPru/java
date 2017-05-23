package gradeBook;

import java.sql.Connection;
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

    }

    private void fillTablesWithInitialData() {

    }


    public boolean addGradingInstance(int studentId, int teacherId, int subjectId, int gradeId, char gradeType) {

        String insertGrade = "INSERT INTO ocenianie VALUES (" + studentId + ", "
                            + teacherId + ", " + subjectId + ", " + gradeId + ", " + "'" + Character.toUpperCase(gradeType) + "'" + ")";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertGrade);

            System.out.println("Dodano nową ocenę.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}