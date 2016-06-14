//Author: Tushar Jaiswal
//Creation Date: 06/14/2016
/*Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/
public class Solution {
    public int StrStr(string haystack, string needle) {
        if(needle.Equals(haystack))
        { return 0; }
        
        for(int i=0; i < haystack.Length-needle.Length+1; i++)
        {
            int j;
            for(j = 0; j < needle.Length; j++)
            {
                if(haystack[i+j] != needle[j])
                {
                    break;
                }
            }
            if(j == needle.Length)
            {
                return i;
            }
        }
        return -1;
    }
}