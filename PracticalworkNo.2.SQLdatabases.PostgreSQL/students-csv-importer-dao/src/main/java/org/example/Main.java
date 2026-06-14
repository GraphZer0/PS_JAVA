package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        System.out.println("=== All students ===");
        List<Student> allStudents = studentDao.findAll();
        System.out.println("Total students: " + allStudents.size());

        System.out.println("\n=== Students with completed test preparation course ===");
        List<Student> completedCourseStudents = studentDao.findByCompletedTestPreparationCourse();
        System.out.println("Count: " + completedCourseStudents.size());
        completedCourseStudents.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=== Students with math score > 90 ===");
        List<Student> highMathScoreStudents = studentDao.findByMathScoreGreaterThan(90);
        System.out.println("Count: " + highMathScoreStudents.size());
        highMathScoreStudents.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=== Female students ===");
        List<Student> femaleStudents = studentDao.findByGender("female");
        System.out.println("Count: " + femaleStudents.size());
        femaleStudents.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=== Male students from group B ===");
        List<Student> maleGroupBStudents = studentDao.findByGenderAndRaceEthnicity("male", "group B");
        System.out.println("Count: " + maleGroupBStudents.size());
        maleGroupBStudents.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}