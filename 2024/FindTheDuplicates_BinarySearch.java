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
    N >> M

    arr1 = [1,100,100000],
    arr2 = [-100, -99, -98, ..... , 1,2, ....., 100, ...., 100000]; -> N

    // TC: O(MlogN) M << N
    M= 2 and N=200
    O(200) vs O(2log200) -> O(2*7)~O(14)
**/
class Solution {
  static int[] findDuplicates(int[] arr1, int[] arr2) {
    int M = arr1.length;
    int N = arr2.length;
    List<Integer> ans = new ArrayList<>();

    for (int i=0; i<M; i++) {
        int num = arr1[i];
        int l = 0;
        int r = N-1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr2[mid] == num) {
                index = mid;
                r = mid-1;
            } else if (arr2[mid] < num) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if (index != -1) {
            ans.add(num);
        }
    }

    return ans.stream().mapToInt(i->i).toArray();
  }

  public static void main(String[] args) {
        // debug your code below
        int[] arr1 = {2};
        int[] arr2 = {2, 2};
        int[] result = findDuplicates(arr1, arr2);

        System.out.print("Duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

