package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final String JDBC_URL = "jdbc:h2:./students_db";

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return findByQuery(sql);
    }

    @Override
    public List<Student> findByCompletedTestPreparationCourse() {
        String sql = "SELECT * FROM students WHERE test_preparation_course = ?";
        return findByQuery(sql, "completed");
    }

    @Override
    public List<Student> findByMathScoreGreaterThan(int score) {
        String sql = "SELECT * FROM students WHERE math_score > ?";
        return findByQuery(sql, score);
    }

    @Override
    public List<Student> findByGender(String gender) {
        String sql = "SELECT * FROM students WHERE gender = ?";
        return findByQuery(sql, gender);
    }

    @Override
    public List<Student> findByRaceEthnicity(String raceEthnicity) {
        String sql = "SELECT * FROM students WHERE race_ethnicity = ?";
        return findByQuery(sql, raceEthnicity);
    }

    @Override
    public List<Student> findByGenderAndRaceEthnicity(String gender, String raceEthnicity) {
        String sql = "SELECT * FROM students WHERE gender = ? AND race_ethnicity = ?";
        return findByQuery(sql, gender, raceEthnicity);
    }

    private List<Student> findByQuery(String sql, Object... params) {
        List<Student> students = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapResultSetToStudent(resultSet));
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }

        return students;
    }

    private Student mapResultSetToStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("gender"),
                resultSet.getString("race_ethnicity"),
                resultSet.getString("parental_level_of_education"),
                resultSet.getString("lunch"),
                resultSet.getString("test_preparation_course"),
                resultSet.getInt("math_score"),
                resultSet.getInt("reading_score"),
                resultSet.getInt("writing_score")
        );
    }
}