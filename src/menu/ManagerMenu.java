package menu;

import model.Student;
import service.ManagerStudent;

import java.util.Scanner;

public class ManagerMenu {
    private final ManagerStudent listStudent = new ManagerStudent();

    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age1 = sc.nextInt();
        System.out.println("Nhập điểm trung bình: ");
        double avg = sc.nextDouble();
        return new Student(name, age1, avg);
    }

    public void mainMenu() {
        System.out.println("--------------------------");
        System.out.println("Menu");
        System.out.println("1. Tìm học sinh: ");
        System.out.println("2. Thêm học sinh: ");
        System.out.println("3. Sửa học sinh: ");
        System.out.println("4. Xóa học sinh: ");
        System.out.println("5. Tổng điểm cả lớp: ");
        System.out.println("6. Sắp xếp theo thứ tự điểm trung bình: ");
        System.out.println("0. Exit");
        System.out.println("--------------------------");
        System.out.println("Enter your choice: ");
    }

    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id học sinh cần tìm:");
        int id = sc.nextInt();
        System.out.println(listStudent.getNameStudent(id));
    }

    public void addStudent() {
        listStudent.add(createStudent());
        listStudent.print();
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        int idS = sc.nextInt();
        listStudent.update(createStudent(), idS);
        listStudent.print();
    }
    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id cần xóa: ");
        int idX = sc.nextInt();
        listStudent.deleteById(idX);
        listStudent.print();
    }

    public void sumAvg() {
        System.out.println(listStudent.sumAvg());
    }

    public void sortStudent() {
        listStudent.sortMinToMax();
        listStudent.print();
    }

    public void checkChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (true) {
            mainMenu();
            while (choice == -1) {
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    sc.nextLine();
                }
            }
            switch (choice) {
                case 1 -> searchStudent();
                case 2 -> addStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> sumAvg();
                case 6 -> sortStudent();
                case 0 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
            choice = -1;
        }
    }
}
