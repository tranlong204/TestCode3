package heap;

import java.util.*;


public class Solution {

    public static List<String> gido() {
        Queue<Pair<Integer, String>> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a.left == b.left) {
                        return b.right.compareTo(a.right);
                    } else {
                        return b.left - a.left;
                    }

                });

        queue.add(new Pair<>(3, "banana"));
        queue.add(new Pair<>(3, "apple"));
        queue.add(new Pair<>(2, "cherry"));
        queue.add(new Pair<>(1, "orange"));

        int count = 3;
        String[] result = new String[count];
//        List<String> result = Arrays.asList(new String[count]);

        while (!queue.isEmpty() && count > 0) {
            Pair<Integer, String> pair = queue.poll();
            result[count - 1] = pair.getRight();
            --count;
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        List<String> result = gido();
        System.out.println(result);
    }
}
