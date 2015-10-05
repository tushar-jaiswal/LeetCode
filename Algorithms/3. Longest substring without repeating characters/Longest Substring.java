//Author: Tushar Jaiswal
//Creation Date: 10/04/2015

/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
This input hits all conditions for the optimal solution: "abdvaabfeghij". The longest substring is ""abfeghij"", with the length of 8
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> substringChars = new HashMap<Character,Integer>();
        int start = 0;
        int length = 0;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(substringChars.containsKey(c) && start<substringChars.get(c)+1) 
            { start = substringChars.get(c)+1; }
            length = Math.max(length, i-start+1);
            substringChars.put(c,i);
        }
        return length;
    }
}
