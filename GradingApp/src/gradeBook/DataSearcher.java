package gradeBook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSearcher {

    protected List getGradeTypes() {
        List<Character> gradeTypes = new ArrayList<>();
        gradeTypes.add('C');    // ocena cząstkowa
        gradeTypes.add('K');    // ocena końcowa
        return gradeTypes;
    }

    protected boolean doesTeacherExist(Connection connection, int teacherId) throws SQLException {
        String query = "SELECT COUNT(*) FROM nauczyciel n WHERE n.idn = " + teacherId;
        return findOutIfRecordExists(connection, query);
    }

    protected boolean doesStudentExist(Connection connection, int studentId) throws SQLException {
        String query = "SELECT COUNT(*) FROM uczen u WHERE u.idu = " + studentId;
        return findOutIfRecordExists(connection, query);
    }

    protected boolean doesSubjectExist(Connection connection, int subjectId) throws SQLException {
        String query = "SELECT COUNT(*) FROM przedmiot p WHERE p.idp = " + subjectId;
        return findOutIfRecordExists(connection, query);
    }

    protected boolean doesGradeExist(Connection connection, int gradeId) throws SQLException {
        String query = "SELECT COUNT(*) FROM ocena o WHERE o.ido = " + gradeId;
        return findOutIfRecordExists(connection, query);
    }

    private boolean findOutIfRecordExists(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        boolean recordExists = false;
        if (results.next()) {
            String result = results.getString("count(*)");
            int count = Integer.parseInt(result);
            System.out.println("Liczba znalezionych rekordow: " + count);

            if (count > 0) {
                recordExists = true;
            } else {
                recordExists = false;
            }
        }
        results.close();
        return recordExists;
    }


}
