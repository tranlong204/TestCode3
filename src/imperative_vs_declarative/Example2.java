package imperative_vs_declarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4,4,4,5,6,7,8,8,8,9,10,10);
        // Imperative
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer i : integerList) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            }
        }

        System.out.println(uniqueList);

        // Declarative
        List<Integer> uniqueList1 = integerList.stream().distinct().toList();
        System.out.println(uniqueList1);
    }
}
