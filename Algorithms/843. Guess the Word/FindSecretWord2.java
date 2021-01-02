//Author: Tushar Jaiswal
//Creation Date: 01/01/2021

/*This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:
master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
*/

/*Runtime Complexity: O(n)
Space Complexity: O(n)*/

import java.util.concurrent.ThreadLocalRandom;

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    private static final int MAX_GUESSES = 10;

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < MAX_GUESSES; i++) {
            HashMap<Character, Integer>[] positionCharFrequency = new HashMap[wordlist[0].length()];
            for (int j = 0; j < wordlist[0].length(); j++) {
                positionCharFrequency[j] = new HashMap<Character, Integer>();
            }

            for (String word : wordlist) {
                for (int j = 0; j < word.length(); j++) {
                    positionCharFrequency[j].merge(word.charAt(j), 1, Integer::sum);
                }
            }

            String guessWord = null;
            int maxFrequency = 0;
            for (String word : wordlist) {
                int frequency = 0;
                for (int j = 0; j < word.length(); j++) {
                    frequency += positionCharFrequency[j].get(word.charAt(j));
                }
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    guessWord = word;
                }
            }

            int characterMatchCount = master.guess(guessWord);

            if (characterMatchCount == guessWord.length()) {
                return;
            }

            List<String> shortlistedWords = new ArrayList<String>();
            for (String candidate : wordlist) {
                if (!candidate.equals(guessWord) && getCharacterMatchCount(guessWord, candidate) == characterMatchCount) {
                    shortlistedWords.add(candidate);
                }
            }
            wordlist = shortlistedWords.toArray(new String[0]);
        }
    }

    private int getCharacterMatchCount(String word1, String word2) {
        int count = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
