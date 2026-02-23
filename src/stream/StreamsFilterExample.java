package stream;

import data.Student;
import data.StudentDataBase;

import java.util.List;

public class StreamsFilterExample {
    public static List<String> nameList() {
        List<String> studentList = StudentDataBase.getAllStudents().stream()
                //Student as an input -> student name
//                .map(Student::getName)
//                .map(String::toUpperCase)
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getName)
                .toList();

        return studentList;
    }

    public static void main(String[] args) {
        System.out.println(nameList());
    }

}
