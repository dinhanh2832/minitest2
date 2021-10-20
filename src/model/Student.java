package model;

public class Student extends People {
    public int id = 0;
    private double avgScore;

    public Student(String name, int age, double avgScore) {
        super(name, age);
        this.avgScore = avgScore;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", id=" + id +
                ", avgScore=" + avgScore +
                '}';
    }
}
