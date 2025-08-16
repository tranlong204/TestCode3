package backtracking;

import java.util.*;

public class StringPartitions {

    public static List<List<String>> partitionString(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String part = s.substring(start, i);
            current.add(part);
            backtrack(s, i, current, result);
            current.remove(current.size() - 1);
        }
    }
/*

 */
    // Example usage
    public static void main(String[] args) {
        String input = "abc";
        List<List<String>> partitions = partitionString(input);
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
