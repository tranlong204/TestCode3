package TwoPointers1;

import java.util.*;

public class MergeArrays {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; ++i) {
            map1.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; ++i) {
            map2.put(nums2[i][0], nums2[i][1]);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int val2 = map2.getOrDefault(entry.getKey(), 0);
            result.add(new int[]{entry.getKey(), entry.getValue() + val2});
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                result.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        result.sort(Comparator.comparingInt(o -> o[0]));

        int[][] array = new int[result.size()][];

        int i = 0;
        for (int[] nestedList : result) {
            array[i++] = nestedList;
        }

        return array;
    }

    public static void main(String[] args) {
        int[][] nums1 = new int[][]{{1,2}, {2,3}, {4,5}};
        int[][] nums2 = new int[][]{{1,4}, {3,2}, {4,1}};

        int[][] result = mergeArrays(nums1, nums2);

        System.out.println(Arrays.deepToString(result));
    }
}
