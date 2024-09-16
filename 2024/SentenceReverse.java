/*
You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

Example:

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]
Constraints:

[time limit] 5000ms

[input] array.character arr

0 ≤ arr.length ≤ 100
[output] array.character
*/

class Solution {

  // SOME MORE CASES TO TEST: {'a', ' ', ' ', 'b'} and {' ', ' '}
  // EXPECTED ['b', ' ', ' ', 'a'] and [' ',' ']
  static char[] reverseWords(char[] arr) {
    String str = new String(arr);
    String[] splitted = str.split(" ");
    if (splitted.length == 0) {
      return arr;
    }
    int l = 0, r = splitted.length-1;
    while (l <= r) {
      String t = splitted[l];
      splitted[l++] = splitted[r];
      splitted[r--] = t;
    }
    StringBuilder sb = new StringBuilder();
    for (String word : splitted) {
      sb.append(word);
      sb.append(" ");
    }
    return sb.toString().trim().toCharArray();
  }

  public static void main(String[] args) {
        // debug your code below
        char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        char[] result = reverseWords(arr);
        
        System.out.print("Reversed words array: ");
        for (char ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}