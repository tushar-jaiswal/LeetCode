//Author: Tushar Jaiswal
//Creation Date: 12/12/2020

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

/*Runtime Complexity: O(|s|)
Space Complexity: O(|p|)*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();

        if (p.length() > s.length()) {
            return result;
        }

        var charFreqMap = new HashMap<Character, Integer>();
        for (char c : p.toCharArray()) {
            charFreqMap.merge(c, 1, Integer::sum);
        }

        int start = 0;
        int end = 0;
        int counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (charFreqMap.containsKey(c)) {
                charFreqMap.merge(c, -1, Integer::sum);
                if (charFreqMap.get(c) == 0) {
                    counter++;
                }
            }
            end++;

            while (counter == charFreqMap.size()) {
                char charToRemove = s.charAt(start);
                if (charFreqMap.containsKey(charToRemove)) {
                    charFreqMap.merge(charToRemove, 1, Integer::sum);
                    if (charFreqMap.get(charToRemove) == 1) {
                        counter--;
                    }
                }

                if (end - start == p.length()) {
                    result.add(start);
                }

                start++;
            }
        }

        return result;
    }
}
