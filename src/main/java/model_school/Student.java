package model_school;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human implements Playable {

    public List<Subject> subjects = new ArrayList<>();

    public Student(String name, int id) {
        super(name, id);
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a student!");
    }

    @Override
    public void teach(Student student, Subject subject) {
        student.addSubject(subject);
    }

    @Override
    public void play() {
        System.out.println("I'm playing football!");
    }

    public void addSubject (Subject subject) {
        subjects.add(subject);
    }
}
