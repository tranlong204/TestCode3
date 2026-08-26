package stream;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class StreamsFindFirstAnyExample {
    private static Optional<Student> findFirstTest() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.8)
                .findFirst();
    }
    private static Optional<Student> findAnyTest() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.8)
                .findAny();
    }

    public static void main(String[] args) {
        System.out.println(findFirstTest());
        System.out.println(findAnyTest());
    }
}
