package org.example;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    List<Student> findByCompletedTestPreparationCourse();

    List<Student> findByMathScoreGreaterThan(int score);

    List<Student> findByGender(String gender);

    List<Student> findByRaceEthnicity(String raceEthnicity);

    List<Student> findByGenderAndRaceEthnicity(String gender, String raceEthnicity);
}