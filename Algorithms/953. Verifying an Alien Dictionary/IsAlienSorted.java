//Author: Tushar Jaiswal
//Creation Date: 11/18/2020

/*In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

Constraints:
    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.*/

/*Runtime Complexity: O(maxLengthWord * Number of Words)
Space Complexity: O(Number of words)*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        var orderMap = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        int maxLength = 0;
        var queue = new LinkedList<String>();
        for (String word : words) {
            if (word != null) {
                if (maxLength < word.length()) {
                    maxLength = word.length();
                }
                queue.add(word);
            }
        }

        int prevWordOrder = -1;
        for (int i = 0; i < maxLength && queue.size() != 0; i++) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize - 1; j++) {
                String word = queue.remove();
                char currWordChar = word.charAt(i);
                char nextWordChar = queue.peek().charAt(i);
                int currWordLen = word.length();
                int nextWordLen = queue.peek().length();

                if(!orderMap.containsKey(currWordChar) || !orderMap.containsKey(nextWordChar)) {
                    throw new IllegalArgumentException("Character in word is not part of Alien dictionary.");
                }

                int currWordOrder = orderMap.get(currWordChar);
                int nextWordOrder = orderMap.get(nextWordChar);
                if (currWordOrder > nextWordOrder || (currWordOrder == nextWordOrder && i + 1 == nextWordLen && currWordLen > nextWordLen)) {
                    return false;
                } else if (currWordOrder == nextWordOrder &&  i + 1 <currWordLen) {
                    queue.add(word);
                    if (j + 1 == queueSize - 1) {
                        // If the next word is the last word in the current iteration to compare order of words
                        word = queue.remove();
                        if (i + 1 < nextWordLen) {
                            queue.add(word);
                        }
                    }
                } else if (currWordOrder == prevWordOrder && i + 1 < currWordLen) {
                    queue.add(word);
                }
                prevWordOrder = currWordOrder;
            }
        }

        return true;
    }
}
