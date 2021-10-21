package service;
import model.People;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagerStudent extends ManagerPeople {
    private ArrayList<Student> students;
    private double sum = 0;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ManagerStudent() {
    }

    public void sortMinToMax() {
        students.sort(Comparator.comparingDouble(Student::getAvgScore));
    }
    public double sumAvg() {
        for (Student student : students) {
            sum += student.getAvgScore();
        }
        return sum;
    }

    @Override
    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
