//Author: Tushar Jaiswal
//Creation Date: 12/26/2020

/*Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy.

Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

Constraints:
    0 <= len(S) <= 100.
    0 <= len(words) <= 100.
    0 <= len(words[i]) <= 100.
    S and all words in words consist only of lowercase letters
*/

/*Runtime Complexity: O(total number of characters of all words)
Space Complexity: O(max(number of characters in a word))*/

import java.util.AbstractMap;

class Solution {
    public int expressiveWords(String S, String[] words) {
        List<Map.Entry<Character, Integer>> targetCharFrequencyList = getCharFrequencyListOfWord(S);
        int count = 0;

        for (String word : words) {
            List<Map.Entry<Character, Integer>> wordCharFrequencyList = getCharFrequencyListOfWord(word);

            if (targetCharFrequencyList.size() != wordCharFrequencyList.size()) {
                continue;
            }

            boolean isStretchy = true;
            for (int i = 0; i < targetCharFrequencyList.size(); i++) {
                char targetChar = targetCharFrequencyList.get(i).getKey();
                char wordChar = wordCharFrequencyList.get(i).getKey();
                int targetCharFrequency = targetCharFrequencyList.get(i).getValue();
                int wordCharFrequency = wordCharFrequencyList.get(i).getValue();

                if (targetChar != wordChar ||
                    (targetCharFrequency < 3 && targetCharFrequency != wordCharFrequency) ||
                    (targetCharFrequency < wordCharFrequency)) {
                    isStretchy = false;
                    break;
                }
            }
            if (isStretchy) {
                count++;
            }
        }

        return count;
    }

    private List<Map.Entry<Character, Integer>> getCharFrequencyListOfWord(String word) {
        var result = new ArrayList<Map.Entry<Character, Integer>>();

        Map.Entry<Character, Integer> charFreq = null;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 || word.charAt(i) != word.charAt(i - 1)) {
                if (charFreq != null) {
                    result.add(charFreq);
                }
                charFreq = new AbstractMap.SimpleEntry<Character, Integer>(word.charAt(i), 0);
            }
            charFreq.setValue(charFreq.getValue() + 1);
        }
        result.add(charFreq);

        return result;
    }
}
