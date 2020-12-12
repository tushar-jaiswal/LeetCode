//Author: Tushar Jaiswal
//Creation Date: 12/12/2020

/*Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/

/*Runtime Complexity: O(n)
Space Complexity: O(k)*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
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

            while (counter > k) {
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
