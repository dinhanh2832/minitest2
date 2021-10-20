package service;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagerStudent extends ManagerPeople {
    private final ArrayList<Student> students;
    private double sum = 0;


    public ManagerStudent() {
        this.students = new ArrayList<>();
    }

    public void sortMinToMax() {
        students.sort(Comparator.comparingDouble(Student::getAvgScore));
    }

    public double sumAvg() {
        for (int i = 0; i < super.getCount(); i++) {
            sum += students.get(i).getAvgScore();
        }
        return sum;
    }
}
