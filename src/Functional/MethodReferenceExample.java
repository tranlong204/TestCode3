package Functional;

import java.util.function.Function;

public class MethodReferenceExample {
    static Function<String, String> toUpperCaseLambda = String::toUpperCase;

    public static void main(String[] args) {

        String ab = toUpperCaseLambda.apply("long");
        System.out.println(ab);

    }
}
