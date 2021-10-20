package service;

import model.People;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagerStudent implements ManagerService<Student> {
    private final ArrayList<Student> students;
    private int count = 0;
    private double sum = 0;

    public ManagerStudent() {
        this.students = new ArrayList<>();
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Student student) {
        student.setId(count);
        count ++;
        students.add(student);

    }

    @Override
    public void update(Student student, int id) {
        int index = findIndexById(id);
        students.set(index, student);
    }

    @Override
    public void deleteById(int id) {
        int index = findIndexById(id);
        students.remove(index);
    }

    @Override
    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void sort() {
        students.sort(Comparator.comparing(People::getName));
    }

    @Override
    public void sortMinToMax() {
        students.sort(Comparator.comparingDouble(Student::getAvgScore));
    }

    @Override
    public Student getNameStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public double sumAvg() {
        for (int i = 0;i < count;i++){
            sum += students.get(i).getAvgScore();
        }
        return sum;
    }
}
