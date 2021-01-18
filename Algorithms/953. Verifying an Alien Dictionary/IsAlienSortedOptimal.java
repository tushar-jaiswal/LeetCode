//Author: Tushar Jaiswal
//Creation Date: 01/18/2020

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
Space Complexity: O(|order|)*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        var orderMap = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!areWordsInOrder(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean areWordsInOrder(String word1, String word2, HashMap<Character, Integer> orderMap) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2) {
                return orderMap.get(c1) < orderMap.get(c2);
            }
        }
        // If one word is the prefix of the other, check their lengths to see if they are in order.
        return word1.length() <= word2.length();
    }
}
