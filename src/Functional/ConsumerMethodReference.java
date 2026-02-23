package Functional;

import java.util.function.Consumer;

public class ConsumerMethodReference {

    static Consumer<Student> c1 = p -> System.out.println(p.getName());
    public static void main(String[] args) {
        c1.accept(new Student("Long"));
        
    }

    private static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
