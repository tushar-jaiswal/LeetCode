//Author: Tushar Jaiswal
//Creation Date: 10/04/2015

/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
This input hits all conditions: "abdvaabfeghij". The longest substring is ""abfeghij"", with the length of 8
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> substringChars = new HashMap<Character, Integer>();
        int longestLength = 0;
        int length = 0;
        //more concise for(char c: s.toCharArray()) - more concise but cost penalty to create a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string
        for(int i = 0; i < s.length(); i++ )
        {
            if(substringChars.get(s.charAt(i)) != null)
            {
                substringChars.clear();
                length = 1;
                substringChars.put(s.charAt(i), i);
            }
            else
            {
                substringChars.put(s.charAt(i), i);
                length++;
                if(length > longestLength)
                {
                    longestLength = length;   
                }
                
                if(i != s.length()-1)
                {
                    int substringLength = lengthOfLongestSubstring(s.substring(i+1));//Find any longer substrings that can be found from the next index
                    if(substringLength > longestLength)
                    {
                        longestLength = substringLength;
                    }
                }
            }
        }
        return longestLength;
    }
}