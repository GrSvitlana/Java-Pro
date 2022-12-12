package model_school;

import maven.Main;

import java.util.Arrays;
import java.util.List;

public class School {

    public static void main(String[] args) {
        Student student1 = new Student("Tom", 1);
        Student student2 = new Student("Bob", 2);
        Student student3 = new Student("Bob", 2);

        Teacher teacher1 = new Teacher("Mr. Thompson", 4);
        Teacher teacher2 = new Teacher("John", 5);

        List<Human> peopleAtSchool = Arrays.asList(student1, student2, student3, teacher1, teacher2);
        List<Student> studentsAtSchool = Arrays.asList(student1, student2, student3);

        for (Human human : peopleAtSchool) {
            System.out.println(human.getName());
        }

        student1.play();
        teacher1.play();

        List<Playable> players = Arrays.asList(student1, student2, student3, teacher1, teacher2);
        for (Playable player : players) {
            player.play();
        }

        Subject subject = null;
        //teacher1.teach(studentsAtSchool, subject);

        teacher1.teach(student1, Subject.Maths);
        teacher1.teach(student1, Subject.English);
        teacher1.teach(student2, Subject.Biology);
        teacher2.teach(student3, Subject.English);

        teacher2.teach(studentsAtSchool, Subject.History);


        for (Student student : studentsAtSchool) {
            System.out.println(student.subjects);
        }
    }
 }
