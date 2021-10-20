package model;

public class Student extends People {
    private double avgScore;

    public Student(String name, int age, double avgScore) {
        super(name, age);
        this.avgScore = avgScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", id=" + super.getId() +
                ", avgScore=" + avgScore +
                '}';
    }
}
