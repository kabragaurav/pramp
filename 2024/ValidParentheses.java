/*
Given a string s containing just the characters '(', ')', '{', '}', '[', and ']', write a function isValid to determine if the input string is valid. An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Return true if the string is valid, otherwise return false.

Examples
Input: s = "({"
Output: false

Input: s = "({[]()})"
Output: true
In the first example, all brackets are properly closed and nested, so the result is true. In the second example, each type of bracket is matched and nested correctly, so the result is also true.

Constraints
The string s has a length of at most 10^4.

@author gauravkabra
@since 2024
 */

 import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
            Stack<Character> stk = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (stk.isEmpty() || ch == '(' || ch == '{' || ch == '[') {
                    stk.push(ch);
                } else if ((ch == ')' && stk.peek() == '(') || (ch == '}' && stk.peek() == '{') || (ch == ']' && stk.peek() == '[')) {
                    stk.pop();
                } else {
                    return false;
                }
            }

        return stk.isEmpty();
    }
}