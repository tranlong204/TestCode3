package SlidingWIndow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] windowFreqs = new int[26];
        int[] expectedFreqs = new int[26];
        for (char c : p.toCharArray()) {
            expectedFreqs[c - 'a'] += 1;
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            windowFreqs[s.charAt(right) - 'a'] += 1;

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(windowFreqs, expectedFreqs)) {
                    result.add(left);
                }
                windowFreqs[s.charAt(left) - 'a'] -= 1;
                left++;
            }
            right++;
        }
        return result;
    }


}
