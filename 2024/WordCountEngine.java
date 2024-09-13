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
 */

import java.util.*;

class Solution {

  static String[][] wordCountEngine(String document) {
    document = document.toLowerCase();
    HashMap<String, Integer> wordToFreq = new HashMap<>();
    HashMap<String, Integer> firstIndex = new HashMap<>();
    String[] words = document.split("\\s+");
    StringBuilder doc = new StringBuilder();
    for (String word : words) {
        doc.append(word);
        doc.append(" ");
    }
    int N = words.length;
    for (int i=0; i<N; i++) {
        words[i] = removePunctuations(words[i]);
        wordToFreq.put(words[i], wordToFreq.getOrDefault(words[i], 0) + 1);
        if (!firstIndex.containsKey(words[i])) {
          firstIndex.put(words[i], i);
        }
    }
    List<Pair> ans = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
        String word = entry.getKey();
        int freq = entry.getValue();
        ans.add(new Pair(word, freq));
    }
    Collections.sort(ans, (p1, p2) -> {
        if (p1.freq == p2.freq) {
            return firstIndex.get(p1.word)-firstIndex.get(p2.word);
        } else {
            return p2.freq - p1.freq;
        }
    });

    String[][] ret = new String[ans.size()][2];
    int i = 0;
    for (Pair p : ans) {
        ret[i++] = new String[] {p.word, Integer.toString(p.freq)};
    }
    return ret;
  }

  static class Pair {
    String word;
    int freq;

    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
  }

  private static String removePunctuations(String word) {
    StringBuilder sb = new StringBuilder();
    for (char ch : word.toCharArray()) {
        if (Character.isAlphabetic(ch)) {
            sb.append(ch);
        }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // "Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?"
  }

}
