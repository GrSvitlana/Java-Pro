package hw25_Okt23_StreamAPI;
/*
A collection:
Arrays.asList(
new Student("Dmitry", 17, Gender.MAN),
new Student("Maxim", 20, Gender.MAN),
new Student("Catherine", 20, Gender.WOMAN),
new Student("Mikhail", 28, Gender.MAN)
Create the necessary classes. Find the average age of male students in this collection. Use Stream API.
 */

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Dmitry", 17, Gender.MAN),
                new Student("Maxim", 20, Gender.MAN),
                new Student("Catherine", 20, Gender.WOMAN),
                new Student("Mikhail", 28, Gender.MAN));

        System.out.printf("The average age of male students is %2.0f", students.stream()
                .filter(student -> student.getGender().equals(Gender.MAN))
                .mapToInt(Student::getAge).average().getAsDouble());
    }
}
