//Author: Tushar Jaiswal
//Creation Date: 06/05/2016

/*Write a function to find the longest common prefix string amongst an array of strings.*/

public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        if(strs.Length == 0) { return ""; }
        if(strs.Length == 1) { return strs[0]; }
        
        int index, i = 0, minLength;
        bool terminate = false;
        StringBuilder result = new StringBuilder();
        
        minLength = strs[0].Length;
        for(index = 1; index < strs.Length; index++)
        {
            if(strs[index].Length < minLength)
            { minLength = strs[index].Length; }
        }
        
        while(!terminate && i < minLength)
        {
            char c = strs[0].ElementAt(i);
            for(index = 1; index < strs.Length; index++)
            {
                if(strs[index].ElementAt(i) != c)
                {
                    terminate = true;
                    break;
                }
            }
            if(!terminate)
            {
                result.Append(c);
                i++;
            }
        }
        
        return result.ToString();
    }
}