//Author: Tushar Jaiswal
//Creation Date: 08/01/2016

/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37*/

public class Solution {
    public int CompareVersion(string version1, string version2) {
        string[] parts1 = version1.Split('.');
        string[] parts2 = version2.Split('.');
        
        int length = Math.Max(parts1.Length, parts2.Length);
        
        for(int i = 0; i < length; i++)
        {
            if(i < parts1.Length && i < parts2.Length)
            {
                int diff = Int32.Parse(parts1[i]) - Int32.Parse(parts2[i]);
                if(diff < 0)
                { return -1; }
                else if (diff > 0)
                { return 1; }
            }
            else if(i < parts1.Length)
            { 
                if(Int32.Parse(parts1[i]) > 0)
                { return 1; }
                else if(Int32.Parse(parts1[i]) < 0)
                { return -1; }
            }
            else
            { 
                if(Int32.Parse(parts2[i]) > 0)
                { return -1; }
                else if(Int32.Parse(parts2[i]) < 0)
                { return 1; }
            }
        }
        
        return 0;
    }
}