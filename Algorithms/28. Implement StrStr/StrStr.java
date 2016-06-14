//Author: Tushar Jaiswal
//Creation Date: 06/14/2016
/*Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(haystack))
        { return 0; }
        for(int i=0; i < haystack.length()-needle.length()+1; i++)
        {
            int j;
            for(j=0; j < needle.length(); j++)
            {
                if(haystack.charAt(i+j) != needle.charAt(j))
                { break; }
            }
            if(j == needle.length())
            { return i; }
        }
        return -1;
    }
}