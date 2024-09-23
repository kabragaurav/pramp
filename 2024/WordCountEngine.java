/*
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

Examples:

input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"], 
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string

@author gauravkabra
@since 2024
 */

 import java.util.ArrayList;
 import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 /**
 
     w1 w2 w2 w1
 
     w1 - 2
     w2 - 2
 
     w1 w2
     w2 w1
 
 
     document = "" -> []
     document = "abc" or "aaa"
     document = ".,"
     document "ab,.,ab"
     document = "     "
     document = "AaA"
 */
class wordCountEngine {
  // TC : O(NlogN)
  // SC : O(N)
  static String[][] wordCountEngine(String document) {
    document = santize(document);
    String[] words = document.split("\\s+");
    HashMap<String, Integer> wordToFreq = new HashMap<>();
    HashMap<String, Integer> wordToFirstIndex = new HashMap<>();

    for (int i=0; i<words.length; i++) {
        String word = words[i];
        wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        wordToFirstIndex.putIfAbsent(word, i);
    }
    int N = wordToFreq.size();
    List<String[]> ans = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
        ans.add(new String[] {entry.getKey(), Integer.toString(entry.getValue())});
    }
    
    Collections.sort(ans, (a, b) -> {
        String word1 = a[0];
        int freq1 = Integer.parseInt(a[1]);
        String word2 = b[0];
        int freq2 = Integer.parseInt(b[1]);

        if (freq1 != freq2) {
            return freq2-freq1;
        }
        int order1 = wordToFirstIndex.get(word1);
        int order2 = wordToFirstIndex.get(word2);
        return order1-order2;
    });

    return ans.stream().toArray(String[][]::new);
  }

  private static String santize(String s) {
    s = s.toLowerCase();
    char[] chs = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (char ch : chs) {
        if (ch == ' ' || Character.isLetter(ch)) {
            sb.append(ch);
        }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
  // "Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?"
  }

}

