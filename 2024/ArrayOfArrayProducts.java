/*
Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.

Solve without using division and analyze your solution's time and space complexities.

Examples:

input:  arr = [8, 10, 2]
output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

input:  arr = [2, 7, 3, 4]
output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]
Constraints:

[time limit] 5000ms

[input] array.integer arr

0 ≤ arr.length ≤ 20
[output] array.integer
*/

class ArrayOfArrayProducts {
  
  public static int[] arrayOfArrayProducts(int[] arr) {
    int N = arr.length;
    if (N <= 1) {
        return new int[] {};
    }

    int[] rightPrefixProduct = new int[N];
    rightPrefixProduct[N-1] = 1;
    for (int i=N-2; i>=0; i--) {
        rightPrefixProduct[i] = rightPrefixProduct[i+1] * arr[i+1];
    }

    int[] ans = new int[N];

    ans[0] = rightPrefixProduct[0];
    int prod = arr[0];

    for (int i=1; i<N; i++) {
        ans[i] = prod * rightPrefixProduct[i];
        prod *= arr[i];
    }

    return ans;
  }

  public static void main(String[] args) {
    
  }

}