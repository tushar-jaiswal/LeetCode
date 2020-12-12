//Author: Tushar Jaiswal
//Creation Date: 12/12/2020

/*Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

/*Runtime Complexity: O(n)
Space Complexity: O(k)*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        var map = new HashMap<Character, Integer>();

        int begin = 0;
        int end = 0;
        int len = 0;
        int counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                counter++;
            }
            map.merge(c, 1, Integer::sum);
            end++;

            while (counter > 2) {
                char toRemove = s.charAt(begin);
                map.merge(toRemove, -1, Integer::sum);
                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                    counter--;
                }
                begin++;
            }

            len = Math.max(len, end - begin);
        }

        return len;
    }
}
