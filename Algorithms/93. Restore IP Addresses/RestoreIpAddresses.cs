//Author: Tushar Jaiswal
//Creation Date: 07/06/2019

/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]*/

/*Runtime Complexity: O(n)
Space Complexity: O(n)*/

public class Solution {
    public IList<string> RestoreIpAddresses(string s) {
        if(s == null || s.Length > 12 || s.Length < 4)
        { return new List<string>(); }
        IList<string> result = new List<string>();
        for(int i = Math.Max(1, s.Length - 9); i <= Math.Min(3, s.Length - 3); i++)
        {
            string s1 = s.Substring(0, i);
            int p1 = Int32.Parse(s1);
            if(!(s1.Length > 1 && s1[0] == '0') && p1 >= 0 && p1 < 256)
            {
                for(int j = Math.Max(1, (s.Length - i) - 6); j <= Math.Min(3, (s.Length - i) - 2); j++)
                {
                    string s2 = s.Substring(i, j);
                    int p2 = Int32.Parse(s2);
                    if(!(s2.Length > 1 && s2[0] == '0') && p2 >= 0 && p2 < 256)
                    {
                        for(int k = Math.Max(1, (s.Length - i - j) - 3); k <= Math.Min(3, (s.Length - i - j) - 1); k++)
                        {
                            string s3 = s.Substring(i + j, k);
                            int p3 = Int32.Parse(s3);
                            if(!(s3.Length > 1 && s3[0] == '0') && p3 >= 0 && p3 < 256)
                            {
                                string s4 = s.Substring(i + j + k, s.Length - (i + j + k));
                                int p4 = Int32.Parse(s4);
                                if(!(s4.Length > 1 && s4[0] == '0') && p4 >= 0 && p4 < 256)
                                {
                                    result.Add(p1 + "." + s2 + "." +s3 + "." +s4);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
