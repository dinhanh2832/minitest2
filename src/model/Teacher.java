package model;

public class Teacher extends People{
    private final String subject;

    public Teacher(String name,int age,String subject) {
        super(name,age);
        this.subject = subject;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", id=" + super.getId() +
                ", subject" + subject +
                '}';
    }
}
