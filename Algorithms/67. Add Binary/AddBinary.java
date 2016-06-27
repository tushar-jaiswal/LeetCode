//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder c = new StringBuilder();
        int i, j;
        String carry = "0";
        
        for(i = a.length()-1, j = b.length()-1; i >= 0 && j >=0; i--, j--)
        {
            String sum = addDigits(String.valueOf(a.charAt(i)), String.valueOf(b.charAt(j)));
            if(sum != "10")
            {
                sum = addDigits(sum, carry);
                if(sum != "10")
                {
                    c.insert(0, sum);
                    carry = "0";
                }
                else
                {
                    c.insert(0, "0");
                    carry = "1";
                }
            }
            else
            {
                c.insert(0, carry);
                carry = "1";
            }
        }
        while(i >= 0)
        {
            String sum = addDigits(String.valueOf(a.charAt(i)), carry);
            if(sum != "10")
            {
                c.insert(0, sum);
                carry = "0";
            }
            else
            {
                c.insert(0, "0");
                carry = "1";
            }
            i--;
        }
        while(j >= 0)
        {
            String sum = addDigits(String.valueOf(b.charAt(j)), carry);
            if(sum != "10")
            {
                c.insert(0, sum);
                carry = "0";
            }
            else
            {
                c.insert(0, "0");
                carry = "1";
            }
            j--;
        }
        
        if(carry.equals("1"))
        { 
            c.insert(0, "1"); 
        }
        return c.toString();
    }
    
    private String addDigits(String a, String b)
    {
        if(a.equals("0"))
        {
            return b;
        }
        if(a.equals("1"))
        {
            if(b.equals("0"))
            { return "1"; }
            else
            { return "10"; }
        }
        return "default";
    }
}