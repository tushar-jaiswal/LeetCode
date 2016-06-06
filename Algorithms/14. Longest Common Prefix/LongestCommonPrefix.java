//Author: Tushar Jaiswal
//Creation Date: 06/05/2016

/*Write a function to find the longest common prefix string amongst an array of strings.*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) { return ""; }
        if(strs.length == 1) { return strs[0]; }
        
        StringBuilder prefix = new StringBuilder();
        boolean terminate = false;
        
        int index, i = 0, minLength = strs[0].length();
        for(index = 1; index < strs.length; index++)
        {
            if(strs[index].length() < minLength)
            { minLength = strs[index].length(); }
        }
        
        while(!terminate && i < minLength)
        {
            char c = strs[0].charAt(i);
            
            for(index = 1; index < strs.length; index++)
            {
                if(strs[index].charAt(i) != c)
                { 
                    terminate = true; 
                    break;
                }
            }
            if(!terminate)
            {
                prefix.append(c);
                i++;
            }
        }
        
        return prefix.toString();
    }
}