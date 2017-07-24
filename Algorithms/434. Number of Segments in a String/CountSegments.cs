//Author: Tushar Jaiswal
//Creation Date: 07/23/2017

/*Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.

Example:
Input: "Hello, my name is John"
Output: 5*/

public class Solution {
    public int CountSegments(string s) {
        bool isSegment = false;
        int count = 0;
        
        foreach(char c in s)
        {
            if(c == ' ')
            {
                if(isSegment)
                {
                    count++;
                    isSegment = false;
                }
            }
            else
            {
                isSegment = true;
            }
        }
        if(isSegment)
        {
            count++;
        }
        
        return count;
    }
}