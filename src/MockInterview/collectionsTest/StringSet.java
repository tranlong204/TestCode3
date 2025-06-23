package MockInterview.collectionsTest;

import java.util.Set;
import java.util.stream.Collectors;

public class StringSet {
    public static void main(String[] args) {
        String str = "abcccad";

        Set<Character> set = str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        for (Character c : set) {
            System.out.println(c);
        }
    }
}
