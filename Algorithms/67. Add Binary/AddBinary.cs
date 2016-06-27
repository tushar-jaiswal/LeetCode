//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/
public class Solution {
    public string AddBinary(string a, string b) {
        StringBuilder c = new StringBuilder();
        int i, j;
        string carry = "0";
        
        for(i = a.Length-1, j = b.Length-1; i >= 0 && j >= 0; i--, j--)
        {
            string sum = addDigits(a[i].ToString(), b[j].ToString());
            if(sum != "10")
            {
                sum = addDigits(sum, carry);
                if(sum != "10")
                {
                    c.Insert(0, sum);
                    carry = "0";
                }
                else
                {
                    c.Insert(0, "0");
                    carry = "1";
                }
            }
            else
            {
                c.Insert(0, carry);
                carry = "1";
            }
        }
        while(i >= 0)
        {
            string sum = addDigits(a[i].ToString(), carry);
            if(sum != "10")
            {
                c.Insert(0, sum);
                carry = "0";
            }
            else
            {
                c.Insert(0, "0");
                carry = "1";
            }
            i--;
        }
        while(j >= 0)
        {
            String sum = addDigits(b[j].ToString(), carry);
            if(sum != "10")
            {
                c.Insert(0, sum);
                carry = "0";
            }
            else
            {
                c.Insert(0, "0");
                carry = "1";
            }
            j--;
        }
        
        if(carry.Equals("1"))
        { 
            c.Insert(0, "1"); 
        }
        return c.ToString();
    }
    
    private string addDigits(string a, string b)
    {
        if(a.Equals("0"))
        {
            return b;
        }
        if(a.Equals("1"))
        {
            if(b.Equals("0"))
            { return "1"; }
            else
            { return "10"; }
        }
        return "";
    }
}