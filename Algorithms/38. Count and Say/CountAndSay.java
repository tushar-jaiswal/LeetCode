//Author: Tushar Jaiswal
//Creation Date: 06/25/2016
/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.*/
public class Solution {
    public String countAndSay(int n) {
        String seq;
        int currentNo, count, prevNo;
        
        if(n <= 0)
        { return ""; }
        if(n == 1)
        { return "1"; }
        if(n == 2)
        { return "11"; }
        seq = "11";
        
        for(int i=2; i < n; i++)
        {
            StringBuffer newSeq = new StringBuffer("");
            prevNo = Character.getNumericValue(seq.charAt(0));
            count = 1;
            for(int j=1; j < seq.length(); j++)
            {
                currentNo = Character.getNumericValue(seq.charAt(j));
                if(currentNo == prevNo)
                { 
                    count++;
                    prevNo = currentNo;
                    if(j == seq.length()-1)
                    {
                        newSeq = newSeq.append(Integer.toString(count) + Integer.toString(currentNo));
                    }
                }
                else
                {
                    newSeq = newSeq.append(Integer.toString(count) + Integer.toString(prevNo));
                    prevNo = currentNo;
                    count = 1;
                    if(j == seq.length()-1)
                    {
                        newSeq = newSeq.append(Integer.toString(count) + Integer.toString(currentNo));
                    }
                }
            }
            seq = newSeq.toString();
        }
        return seq;
    }
}