/*
Given an array of integers arr, write a function absSort(arr), that sorts the array according to the absolute values of the numbers in arr. If two numbers have the same absolute value, sort them according to sign, where the negative numbers come before the positive numbers.

Examples:

input:  arr = [2, -7, -2, -2, 0]
output: [0, -2, -2, 2, -7]
Constraints:

[time limit] 5000ms
[input] array.integer arr
0 ≤ arr.length ≤ 10
[output] array.integer
*/

import java.util.*;
import java.util.stream.*;

class Solution {
    static int[] absSort(int[] arr) {
        List<Integer> ls = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ls, (a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA != absB) {
                return absA-absB;
            } else {
                return a-b; 
            }
        });
        return ls.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(absSort(new int[] {-3, 2})));   // 2, -3
        System.out.println(Arrays.toString(absSort(new int[] {2, -2})));   // -2 2
    }
}
