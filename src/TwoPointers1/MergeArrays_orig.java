package TwoPointers1;

import java.util.*;

public class MergeArrays_orig {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; ++i) {
            map1.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; ++i) {
            map2.put(nums2[i][0], nums2[i][1]);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
            int val2 = map2.getOrDefault(entry.getKey(), 0);
            result.add(new ArrayList<>(List.of(entry.getKey(), entry.getValue() + val2)));
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
            if (!map1.containsKey(entry.getKey())) {
                result.add(List.of(entry.getKey(), entry.getValue()));
            }
        }

        result.sort(Comparator.comparingInt(o -> o.get(0)));

        int[][] array = new int[result.size()][];

        int i = 0;
        for (List<Integer> nestedList : result) {
            array[i++] = nestedList.stream().mapToInt(j->j).toArray();
        }

        return array;
    }
}
