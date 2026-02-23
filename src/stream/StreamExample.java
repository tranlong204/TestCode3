package stream;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        Predicate<Student> studentFemalePredicate = (student -> student.getGender().equals("female"));
        Predicate<Student> studentGPA = (student -> student.getGpa() >= 3.9);

        // student name and their activities in a map
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .peek((System.out::println))
                .filter(studentFemalePredicate)
                .peek(student -> {
                    System.out.println("after 1st filter: " + student);})
                .filter(studentGPA)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

//        System.out.println(studentMap);
    }
}
