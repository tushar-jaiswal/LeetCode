//Author: Tushar Jaiswal
//Creation Date: 07/06/2019

/*Given a String containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]*/

/*Runtime Complexity: O(n)
Space Complexity: O(n)*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() > 12 || s.length() < 4)
        { return new ArrayList<String>(); }
        List<String> result = new ArrayList<String>();
        for(int i = Math.max(1, s.length() - 9); i <= Math.min(3, s.length() - 3); i++)
        {
            String s1 = s.substring(0, i);
            int p1 = Integer.parseInt(s1);
            if(!(s1.length() > 1 && s1.charAt(0) == '0') && p1 >= 0 && p1 < 256)
            {
                for(int j = Math.max(1, (s.length() - i) - 6); j <= Math.min(3, (s.length() - i) - 2); j++)
                {
                    String s2 = s.substring(i, i + j);
                    int p2 = Integer.parseInt(s2);
                    if(!(s2.length() > 1 && s2.charAt(0) == '0') && p2 >= 0 && p2 < 256)
                    {
                        for(int k = Math.max(1, (s.length() - i - j) - 3); k <= Math.min(3, (s.length() - i - j) - 1); k++)
                        {
                            String s3 = s.substring(i + j, i + j + k);
                            int p3 = Integer.parseInt(s3);
                            if(!(s3.length() > 1 && s3.charAt(0) == '0') && p3 >= 0 && p3 < 256)
                            {
                                String s4 = s.substring(i + j + k, s.length());
                                int p4 = Integer.parseInt(s4);
                                if(!(s4.length() > 1 && s4.charAt(0) == '0') && p4 >= 0 && p4 < 256)
                                {
                                    result.add(p1 + "." + s2 + "." +s3 + "." +s4);
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
