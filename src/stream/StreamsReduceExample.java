package stream;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {

    public static Optional<Integer> performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a*b);
    }

    public static Optional<Student> getHighestGPAStudent() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3);
        System.out.println(performMultiplication(integerList).get());

        Optional<Student> highestGPAStudent = getHighestGPAStudent();
        highestGPAStudent.ifPresent(System.out::println);
    }
}
