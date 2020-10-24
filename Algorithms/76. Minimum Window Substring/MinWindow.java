//Author: Tushar Jaiswal
//Creation Date: 10/24/2020

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
* If there is no such window in S that covers all characters in T, return the empty string "".
* If there is such window, you are guaranteed that there will always be only one unique minimum window in S.*/

/*Runtime Complexity: O(number of characters in s)
Space Complexity: O(number of characters in t)*/

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals("")) {
            return "";
        }

        // Using Streams
        // Map<Character, Integer> charFreq = t.chars()
        //        .mapToObj(c -> (char)c)
        //        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            charFreq.merge(c, 1, Integer::sum);
        }
        HashMap<Character, Integer> charsToMatch = new HashMap<>(charFreq);
        HashMap<Character, Integer> excessChars = new HashMap<>();

        String minWindow = null;
        int left = -1;
        int right = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(charFreq.containsKey(c)) {
                left = left == -1 ? i : left;

                if (charsToMatch.containsKey(c)) {
                    charsToMatch.replace(c, charsToMatch.get(c) - 1);
                    if (charsToMatch.get(c) == 0) {
                        charsToMatch.remove(c);
                        if(charsToMatch.size() == 0) {
                            right = i;
                            minWindow = s.substring(left, right + 1);
                            break;
                        }
                    }
                } else {
                    excessChars.merge(c, 1, Integer::sum);
                }
            }
        }
        if (minWindow == null) {
            return "";
        }


        while (left < right && right < s.length()) {
            char c = s.charAt(left);

            if(charFreq.containsKey(c) && !excessChars.containsKey(c)) {
                char newChar = '0';
                do {
                    right++;
                    if (right < s.length()) {
                    newChar = s.charAt(right);

                        if (newChar == c) {
                            left++;
                        } else if (charFreq.containsKey(newChar)) {
                            excessChars.merge(newChar, 1, Integer::sum);
                        }
                    }
                } while (right < s.length() && newChar != c);
            } else if (charFreq.containsKey(c) && excessChars.containsKey(c)) {
                left++;
                minWindow = minWindow.length() > (right - left + 1) ? s.substring(left, right + 1) : minWindow;
                excessChars.replace(c, excessChars.get(c) - 1);
                if (excessChars.get(c) == 0) {
                    excessChars.remove(c);
                }
            } else {
                left++;
                minWindow = minWindow.length() > (right - left + 1) ? s.substring(left, right + 1) : minWindow;
            }
        }

        return minWindow;
    }
}
