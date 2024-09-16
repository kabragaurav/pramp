/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/

import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int ans = helper(coins, 0, N, 0, amount);
        return ans >= 999_999_999 ? -1 : ans;
    }

    private int helper(int[] coins, int curr, int N, int amountSoFar, int target) {
        if (target < amountSoFar) {
            return 999_999_999;
        }
        if (curr == N) {
            return amountSoFar == target ? 0 : 999_999_999;
        }

        String key = curr + "_" + amountSoFar;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int with = 1 + helper(coins, curr, N, amountSoFar+coins[curr], target);
        int without = helper(coins, curr+1, N, amountSoFar, target);
        int ans = Math.min(with, without);
        cache.put(key, ans);
        return ans;
    }
}