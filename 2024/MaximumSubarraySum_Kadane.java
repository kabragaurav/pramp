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

class MaximumSubarraySum_Kadane {
    public int maxSubArray(int[] nums) {
        int global = Integer.MIN_VALUE;
        int local = 0;

        for (int i=0; i<nums.length; i++) {
            local += nums[i];
            global = Math.max(global, local);
            local = Math.max(0, local);
        }

        return global;
    }
}