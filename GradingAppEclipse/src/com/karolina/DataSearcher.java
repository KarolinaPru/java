package com.karolina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSearcher {

    private final Connection connection;

    public DataSearcher(Connection connection) {
        this.connection = connection;
    }

    protected List getGradeTypes() {
        List<Character> gradeTypes = new ArrayList<>();
        gradeTypes.add('C');    // ocena czastkowa
        gradeTypes.add('K');    // ocena koncowa
        return gradeTypes;
    }

    protected boolean doesTeacherExist(int teacherId) throws SQLException {
        String query = "SELECT 1 FROM nauczyciel n WHERE n.idn = " + teacherId;
        return findOutIfRecordExists(query);
    }

    protected boolean doesStudentExist(int studentId) throws SQLException {
        String query = "SELECT 1 FROM uczen u WHERE u.idu = " + studentId;
        return findOutIfRecordExists(query);
    }

    protected boolean doesSubjectExist(int subjectId) throws SQLException {
        String query = "SELECT 1 FROM przedmiot p WHERE p.idp = " + subjectId;
        return findOutIfRecordExists(query);
    }

    protected boolean doesGradeExist(int gradeId) throws SQLException {
        String query = "SELECT 1 FROM ocena o WHERE o.ido = " + gradeId;
        return findOutIfRecordExists(query);
    }

    private boolean findOutIfRecordExists(String query) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet results = statement.executeQuery(query);

        boolean recordExists = false;
        int rowCount = results.last() ? results.getRow() : 0;

        if(rowCount > 0) {
            recordExists = true;
        }
        results.close();
        return recordExists;
    }
}
