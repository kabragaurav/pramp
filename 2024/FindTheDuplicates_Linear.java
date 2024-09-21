/*
Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space complexities of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.

Example:

input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]

output: [3, 6, 7] # since only these three values are both in arr1 and arr2
Constraints:

[time limit] 5000ms

[input] array.integer arr1

1 ≤ arr1.length ≤ 100
[input] array.integer arr2

1 ≤ arr2.length ≤ 100
[output] array.integer
*/

import java.util.*;
/***
    TC: O(max(M, N))
    SC: O(max(M, N))
**/
class FindTheDuplicates_Linear {
  static int[] findDuplicates(int[] arr1, int[] arr2) {
    int M = arr1.length;  // 2
    int N = arr2.length;  // 200

    int i = 0;
    int j = 0;
    List<Integer> ans = new ArrayList<>();
    while (i < M && j < N) {
        if (arr1[i] == arr2[j]) {
            ans.add(arr1[i]);
            i++;
            j++;
        } else if (arr1[i] < arr2[j]) {
            i++;
        } else {
            j++;
        }
    }

    return ans.stream().mapToInt(k->k).toArray();
  }

  public static void main(String[] args) {
        // debug your code below
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};
        int[] result = findDuplicates(arr1, arr2);

        System.out.print("Duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}