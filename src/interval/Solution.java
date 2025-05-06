package interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    [1,2,3,5,7,8]
    ["1->3", "5", "7->8"]
     */
    public static String[] generateIntervals(int[] nums) {
        List<String> result = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (count == 1) {
                    result.add(String.valueOf(nums[i - count]));
                } else if (count > 1) {
                    result.add("" + nums[i - count] + "->" + nums[i - 1]);
                }
                count = 1;
            } else {
                count++;
            }
        }
        if (count == 1) {
            result.add(String.valueOf(nums[nums.length - 1]));
        } else if (count > 1) {
            result.add("" + nums[nums.length - count] + " ->" + nums[nums.length - 1]);
        }
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 7, 8};
        String[] intervals = generateIntervals(nums);
        for (String interval : intervals) {
            System.out.println(interval);
        }
    }
}
