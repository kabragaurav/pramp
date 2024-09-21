/*
A letter can be encoded to a number in the following way:

'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'

Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.

Examples:

input:  S = '1262'
output: 3
explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.
Constraints:

[time limit] 5000ms

[input] string S

1 ≤ S.length ≤ 12
[output] integer

@author gauravkabra
@since 2024
 */

import java.util.*;

class DecodeVariations {
    private static HashMap<String, Integer> cache;

    public int numDecodings(String s) {
        cache = new HashMap<>();
		int N = s.length();
        return helper(s, 0, 0, N);
    }

    private static int helper(String s, int left, int right, int N) {
        String key = left + "_" + right;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (right == N) {
            String substr = s.substring(left, right);
            if (substr.length() > 2 || substr.startsWith("0")) {
                return 0;
            }
            int num = Integer.parseInt(substr);
            if (1 <= num && num <= 26) {
                return 1;
            }
            return 0;
        }
        String substr = s.substring(left, right);
        int with = 0;
        if (!substr.equals("") && substr.length() <= 2 && !substr.startsWith("0")) {
            int num = Integer.parseInt(substr);
            if (1 <= num && num <= 26) {
                with = helper(s, right, right, N);
            }
        }
        
        int without = helper(s, left, right+1, N);
        int ans = with + without;
        cache.put(key, ans);
        return ans;
    }
}