package imperative_vs_declarative;

import java.util.stream.IntStream;

public class Example1 {
    public static void main(String[] args) {

        // Imperative - How
        int sum = 0;
//        sum = 101 * 50;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        // Declarative style of programming
        int sum1 = IntStream.rangeClosed(0, 100).sum();
        System.out.println(sum1);
    }
}
