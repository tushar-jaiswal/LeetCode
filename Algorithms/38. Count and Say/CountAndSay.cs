//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.*/
public class Solution {
    public string CountAndSay(int n) {
        string seq;
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
            StringBuilder newSeq = new StringBuilder();
            prevNo = (int) Char.GetNumericValue(seq[0]);
            count = 1;
            for(int j=1; j < seq.Length; j++)
            {
                currentNo = (int) Char.GetNumericValue(seq[j]);
                if(currentNo == prevNo)
                { 
                    count++;
                    prevNo = currentNo;
                    if(j == seq.Length-1)
                    {
                        newSeq = newSeq.Append(count.ToString() + currentNo.ToString());
                    }
                }
                else
                {
                    newSeq = newSeq.Append(count.ToString() + prevNo.ToString());
                    prevNo = currentNo;
                    count = 1;
                    if(j == seq.Length-1)
                    {
                        newSeq = newSeq.Append(count.ToString() + currentNo.ToString());
                    }
                }
            }
            seq = newSeq.ToString();
        }
        return seq;
    }
}