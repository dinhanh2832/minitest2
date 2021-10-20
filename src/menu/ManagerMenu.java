package menu;

import model.Student;
import model.Teacher;
import service.ManagerPeople;
import service.ManagerStudent;

import java.util.Scanner;

public class ManagerMenu {
    private final ManagerPeople listPeople = new ManagerPeople();
    private final ManagerStudent listStudent = new ManagerStudent();

    public void addPeople(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Giáo viên");
        System.out.println("2: Học sinh");
        System.out.println("Chọn đối tượng muốn thêm:");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> {
                listPeople.add(createTeacher());
                listPeople.print();
            }
            case 2 -> {
                listPeople.add(createStudent());
                listPeople.print();
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
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
    public Teacher createTeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age1 = sc.nextInt();
        System.out.println("Nhập môn dạy: ");
        sc.nextLine();
        String subject = sc.nextLine();
        return new Teacher(name, age1, subject);
    }

    public void mainMenu() {
        System.out.println("--------------------------");
        System.out.println("Menu");
        System.out.println("1. Tìm học sinh: ");
        System.out.println("2. Sửa học sinh: ");
        System.out.println("3. Xóa học sinh: ");
        System.out.println("4. Tổng điểm cả lớp: ");
        System.out.println("5. Sắp xếp theo thứ tự điểm trung bình của học sinh: ");
        System.out.println("6. Thêm đối tượng: ");
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

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        int idS = sc.nextInt();
        listStudent.update(createStudent(), idS);
        listStudent.print();
    }

    public void deleteStudent() {
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
        for (int i = 0;i < listPeople.getCount();i++){
            if(listPeople.getPeoples().get(i) instanceof Student){
                listStudent.add(listPeople.getPeoples().get(i));
            }
        }
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
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> sumAvg();
                case 5 -> sortStudent();
                case 6 -> addPeople();
                case 0 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
            choice = -1;
        }
    }
}
