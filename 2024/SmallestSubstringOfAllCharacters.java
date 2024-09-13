/*
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
Constraints:

[time limit] 5000ms

[input] array.character arr

1 ≤ arr.length ≤ 30
[input] string str

1 ≤ str.length ≤ 500
[output] string
 */

import java.util.*;

class Solution {
    public static String getShortestUniqueSubstring(char[] chs, String s) {
        String t = new String(chs);
        HashMap<Character, Integer> tCharFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tCharFreq.put(ch, tCharFreq.getOrDefault(ch, 0) + 1);
        }

        int desired = t.length();
        int have = 0;
        HashMap<Character, Integer> sCharFreq = new HashMap<>();
        int i = 0;
        int j = 0;
        String ans = "";

        while (j < s.length()) {
            // acquire
            while (j < s.length() && have < desired) {
                char ch = s.charAt(j);
                sCharFreq.put(ch, sCharFreq.getOrDefault(ch, 0) + 1);
                if (sCharFreq.get(ch) <= tCharFreq.getOrDefault(ch, 0)) {
                    have++;
                }
                j++;
            }

            // update ans and release
            while (i <= j && have == desired) {
                String window = s.substring(i, j);
                if (ans.isEmpty() || window.length() < ans.length()) {
                    ans = window;
                }
                char ch = s.charAt(i);
                if (sCharFreq.get(ch) == 1) {
                    sCharFreq.remove(ch);
                } else {
                    sCharFreq.put(ch, sCharFreq.get(ch)-1);
                }
                if (sCharFreq.getOrDefault(ch, 0) < tCharFreq.getOrDefault(ch, 0)) {
                    have--;
                }
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[] {'A'}, "A"));
        System.out.println(getShortestUniqueSubstring(new char[] {'A', 'B', 'C'}, "ADOBECODEBANCDDD")); // Output: "BANC"
    }
}
