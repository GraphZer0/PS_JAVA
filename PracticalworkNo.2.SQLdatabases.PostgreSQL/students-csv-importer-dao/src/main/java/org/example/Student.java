package org.example;

public class Student {

    private int id;
    private String gender;
    private String raceEthnicity;
    private String parentalLevelOfEducation;
    private String lunch;
    private String testPreparationCourse;
    private int mathScore;
    private int readingScore;
    private int writingScore;

    public Student(
            int id,
            String gender,
            String raceEthnicity,
            String parentalLevelOfEducation,
            String lunch,
            String testPreparationCourse,
            int mathScore,
            int readingScore,
            int writingScore) {
        this.id = id;
        this.gender = gender;
        this.raceEthnicity = raceEthnicity;
        this.parentalLevelOfEducation = parentalLevelOfEducation;
        this.lunch = lunch;
        this.testPreparationCourse = testPreparationCourse;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.writingScore = writingScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", raceEthnicity='" + raceEthnicity + '\'' +
                ", parentalLevelOfEducation='" + parentalLevelOfEducation + '\'' +
                ", lunch='" + lunch + '\'' +
                ", testPreparationCourse='" + testPreparationCourse + '\'' +
                ", mathScore=" + mathScore +
                ", readingScore=" + readingScore +
                ", writingScore=" + writingScore +
                '}';
    }
}
