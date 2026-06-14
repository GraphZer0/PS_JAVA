package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    private static final String JDBC_URL = "jdbc:h2:./students_db";
    private static final String CSV_FILE = "StudentsPerformance.csv";

    public static void main(String[] args) {
        createTable();
        clearTable();
        importCsv();
        printStudentCount();
    }
    private static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    gender VARCHAR(20),
                    race_ethnicity varchar(50),
                    parental_level_of_education varchar(100),
                    lunch VARCHAR(50),
                    test_preparation_course VARCHAR(50),
                    math_score INT,
                    reading_score INT,
                    writing_score INT
                )
                """;

        try (
            Connection connection = DriverManager.getConnection(JDBC_URL);
            Statement statement = connection.createStatement();
        ) {
            statement.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private static void clearTable() {
        String sql = "DELETE FROM students";

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()
        ) { statement.executeUpdate(sql);
            System.out.println("Table students cleared");
        } catch (SQLException e) {
            System.out.println("Error while clearing table");
            e.printStackTrace();
        }
    }

    private static void importCsv() {
        String sql = """
                INSERT INTO students (
                gender,
                race_ethnicity,
                parental_level_of_education,
                lunch,
                test_preparation_course,
                math_score,
                reading_score,
                writing_score)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (
                Connection connection = DriverManager.getConnection(JDBC_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE));
                ) {
            reader.readLine();

            String line;
            int importedRows = 0;

            while ((line = reader.readLine()) != null) {
                String[] columns =  line.split(",");

                preparedStatement.setString(1, clean(columns[0]));
                preparedStatement.setString(2, clean(columns[1]));
                preparedStatement.setString(3, clean(columns[2]));
                preparedStatement.setString(4, clean(columns[3]));
                preparedStatement.setString(5, clean(columns[4]));
                preparedStatement.setInt(6, Integer.parseInt(clean(columns[5])));
                preparedStatement.setInt(7, Integer.parseInt(clean(columns[6])));
                preparedStatement.setInt(8, Integer.parseInt(clean(columns[7])));

                preparedStatement.executeUpdate();
                importedRows++;
            }
            System.out.println("Imported " + importedRows);
        } catch (SQLException e) {
            System.out.println("Database error while importing CSV:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error while importing CSV:");
            e.printStackTrace();
        }
    }
    private static void printStudentCount() {
        String sql = " SELECT COUNT(*) FROM students";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            if (resultSet.next()) {
                System.out.println("Students count in database: " + resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Error while counting students:");
            e.printStackTrace();
        }
    }

    private static String clean(String value) {
        return value.replace("\"", "").trim();
    }

}