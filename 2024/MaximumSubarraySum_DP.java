public class MaximumSubarraySum_DP {
    
}
/*
Given an array of integers nums, write a function maxSubarraySum to find the maximum sum of a contiguous subarray within the array and return that maximum sum. The subarray must be contiguous, meaning that the elements must appear consecutively in the original array.

Examples
Input: nums = [2, 3, -2, 4]  
Output: 7  
Explanation: Maximum sum is 2 + 3 + (-2) + 4 = 7.

Input: nums = [1, -1, -5, -4]  
Output: -1  
Explanation: The maximum sum is -1, which is the single element with the highest value.

@author gauravkabra
@since 2024
*/

// BUT IT WILL GIVE TLE
class Solution {
    private static int ans;

    static int maxSubarraySum(int[] arr) {
        ans = Integer.MIN_VALUE;
        int N = arr.length;
        if (N == 0) {
            return 0;
        }
        helper(arr, 0, N, 0);
        return ans;
    }

    private static void helper(int[] arr, int curr, int N, int sumSoFar) {
        if (curr == N) {
            return;
        }
        
        sumSoFar += arr[curr];
        
        ans = Math.max(ans, sumSoFar);

        helper(arr, curr + 1, N, sumSoFar);
        helper(arr, curr + 1, N, 0);
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarraySum(arr));  // Output should be 6
    }
}
 