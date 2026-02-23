package Functional;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Function<String, String> addSomething = (name) -> name.toUpperCase().concat(" default");

        System.out.println(addSomething.apply("Long").concat("abc"));
    }
}
