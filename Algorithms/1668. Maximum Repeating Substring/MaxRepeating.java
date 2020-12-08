//Author: Tushar Jaiswal
//Creation Date: 11/28/2020

/*For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.

Given strings sequence and word, return the maximum k-repeating value of word in sequence.

Example 1:
Input: sequence = "ababc", word = "ab"
Output: 2
Explanation: "abab" is a substring in "ababc".

Example 2:
Input: sequence = "ababc", word = "ba"
Output: 1
Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".

Example 3:
Input: sequence = "ababc", word = "ac"
Output: 0
Explanation: "ac" is not a substring in "ababc".

Constraints:
    1 <= sequence.length <= 100
    1 <= word.length <= 100
    sequence and word contains only lowercase English letters.*/

/*Runtime Complexity: O(length of sequence * (length of sequence - length of word + 1))
Space Complexity: O(1)*/

class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxCount = 0;
        int count = 0;
        int wordPos = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == word.charAt(wordPos)) {
                if(wordPos == word.length() - 1) {
                    wordPos = 0;
                    count++;
                    maxCount = Math.max(count, maxCount);
                } else {
                    wordPos++;
                }
            } else {
                i = i - word.length() * count - wordPos;
                count = 0;
                wordPos = 0;
            }
        }
        return maxCount;
    }
}
