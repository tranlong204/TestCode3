package stream;

import data.Student;
import data.StudentDataBase;

public class StreamsMapFilterReduceExample {

    private static int noOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .filter(student -> student.getGpa() >= 3)
                .filter(student -> student.getGender().equals("female")) //Stream<Student>
                .map(Student::getNoteBooks) //Stream<Integer>
                .reduce(0, (a,b) -> a+b);
    }

    public static void main(String[] args) {
        System.out.println("Number of note book: " + noOfNoteBooks());
    }
}
