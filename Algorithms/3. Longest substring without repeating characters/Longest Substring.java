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
            if(longestLength < (s.substring(i)).length() + length)
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
                    
                    String substring = s.substring(i+1);
                    if(longestLength < substring.length())
                    {
                        HashMap<Character, Integer> substringChars2 = new HashMap<Character, Integer>();
                        int length2 = 0;
                        for (int j = i+1; j < substring.length(); j++)
                        {
                            if(substringChars2.get(s.charAt(i)) != null)
                            {
                                break;
                            }
                            else
                            {
                                substringChars2.put(s.charAt(i), i);
                                length2++;
                                if(length2 > longestLength)
                                {
                                    longestLength = length2;   
                               }
                            }
                        }
                    }
                }
            }
            else
            {
                substringChars.clear();
                length = 1;
                substringChars.put(s.charAt(i), i);
            }
        }
        return longestLength;
    }
}
