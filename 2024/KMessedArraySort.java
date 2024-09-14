/*
Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

0 ≤ k ≤ 20
[output] array.integer

@author gauravkabra
@since 2024
 */

 import java.util.*;
 
 class Solution {
 
   static int[] sortKMessedArray(int[] arr, int k) {
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     int index = 0;
     for (int i=0; i<=k; i++) {
         pq.add(arr[i]);
     }
 
     for (int i=k+1; i<arr.length; i++) {
         arr[index++] = pq.poll();
         pq.add(arr[i]);
     }
 
     while (!pq.isEmpty()) {
         arr[index++] = pq.poll();
     }
     return arr;
   }
 
   public static void main(String[] args) {
         // debug your code below
         int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
         int k = 2;
         int[] result = sortKMessedArray(arr, k);
 
         System.out.print("Sorted KMessed Array: ");
         for (int num : result) {
             System.out.print(num + " ");
         }
     }
 }