package stream;

import data.Student;
import data.StudentDataBase;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamDistinctCountSortedExample {

    public static List<String> printStudentActivities() {
           return StudentDataBase.getAllStudents().stream()
                   .map(Student::getActivities) //Stream<List<String>>
                   .flatMap(List::stream)// Stream<String>
                   .distinct()
                   .sorted(Collections.reverseOrder())
                   .collect(toList());

    }
    public static void main(String[] args) {
        System.out.println(printStudentActivities());
    }
}
