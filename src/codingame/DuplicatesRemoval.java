package codingame;

import java.util.*;
import java.util.function.*;

public class DuplicatesRemoval {
    public static int[] filterDuplicates(int[] data) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : data) {
            if (!set.contains(n)) {
                set.add(n);
                list.add(n);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
//        int[] result = filterDuplicates(new int[]{4,4,2,5});
//        for (int n : result) {
//            System.out.println(n);
//        }

//        System.out.println(Arrays.toString(HashSet.class.getNestMembers()));
//        Class[] classes = DuplicatesRemoval.class.getDeclaredClasses();
//        for (Class c : classes) {
//            System.out.println(c.getName());
//        }


        Supplier<Double> random = () -> Math.random();

        System.out.println(random.get());

        Function<String, Integer> strLen = s -> s.length();

        System.out.println(strLen.apply("abc"));
    }

}
