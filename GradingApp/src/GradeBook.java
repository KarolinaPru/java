import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by karol on 19.05.2017.
 */
public class GradeBook {
    private List<Character> gradeTypes = new ArrayList<>();
    private List<String> gradeDescriptions = new ArrayList<>();
    private List<Integer> grades = new ArrayList<>();
    private List<Integer> teacherIds = new ArrayList<>();
    private List<Integer> studentIds = new ArrayList<>();
    private List<Integer> gradeIds = new ArrayList<>();
    private List<Integer> subjectIds = new ArrayList<>();

    protected List getGradeTypes() {
        gradeTypes.add('S');    // ocena semestralna
        gradeTypes.add('C');    // ocena cząstkowa
        return gradeTypes;
    }

    protected List getTeacherById(Connection connection, int teacherId) throws SQLException {
        String query = "SELECT n.idn FROM nauczyciel n WHERE idn = teacherId";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        //if (results)
        results.close();
        return teacherIds;
    }

    protected List getStudentIds(Connection connection) throws SQLException {
        String query = "SELECT u.idu FROM uczen u";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            int studentId = results.getInt("idu");
            studentIds.add(studentId);
        }
        results.close();
        return studentIds;
    }

    protected List getSubjectIds(Connection connection) throws SQLException {
        String query = "SELECT p.idp FROM przedmiot p";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            int subjectId = results.getInt("idp");
            subjectIds.add(subjectId);
        }
        results.close();
        return subjectIds;
    }

    protected List getGradeIds(Connection connection) throws SQLException {
        String query = "SELECT o.ido FROM ocena o";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            int gradeId = results.getInt("ido");
            gradeIds.add(gradeId);
        }
        results.close();
        return gradeIds;
    }

    protected List getGradeDescriptions(Connection connection) throws SQLException {
        String query = "SELECT o.wartosc_opisowa FROM ocena o";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String description = results.getString("wartosc_opisowa");
            gradeDescriptions.add(description);
        }
        results.close();
        return gradeDescriptions;
    }

    protected List getGrades(Connection connection) throws SQLException {
        String query = "SELECT o.wartosc_numeryczna FROM ocena o";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            int grade = results.getInt("wartosc_numeryczna");
            grades.add(grade);
        }
        results.close();
        return grades;
    }

}
