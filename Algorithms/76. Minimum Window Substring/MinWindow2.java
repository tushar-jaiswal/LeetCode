//Author: Tushar Jaiswal
//Creation Date: 12/12/2020

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
* If there is no such window in S that covers all characters in T, return the empty string "".
* If there is such window, you are guaranteed that there will always be only one unique minimum window in S.*/

/*Runtime Complexity: O(|s|)
Space Complexity: O(|t|)*/

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        var charFreqMap = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            charFreqMap.merge(c, 1, Integer::sum);
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int counter = 0;
        String result = "";

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

                result = end - start < len ? s.substring(start, end) : result;
                len = Math.min(len, end - start);

                start++;
            }
        }

        return result;
    }
}
