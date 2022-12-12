package model_school;

import java.util.List;

public class Teacher extends Human implements Teachable, Playable{

    public Teacher(String name, int id) {
        super(name, id);
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a teacher!");
    }

    @Override
    public void play() {
        System.out.println("I play chess");
    }

    @Override
    public void teach(Student student, Subject subject) {
        System.out.println("Teacher " + this.getName() + " teaches a student " + student.getName());
        student.addSubject(subject);
    }

    @Override
    public void teach(List<Student> students, Subject subject) {
        for (Student student : students) {
            this.teach(student, subject);
        }
    }
}
