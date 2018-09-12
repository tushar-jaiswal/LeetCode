//Author: Tushar Jaiswal
//Creation Date: 09/11/2018

/*Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.*/

public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> dict = new Dictionary<string, List<string>>();
        foreach(string str in strs)
        {
            int[] count = new int[26];
            foreach(char c in str)
            { count[c - 'a']++; }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++)
            { sb.Append(count[i]); }
            String freqString = sb.ToString();
            if(!dict.ContainsKey(freqString))
            { dict[freqString] = new List<string>();  }
            dict[freqString].Add(str);
        }
        return new List<IList<string>>(dict.Values);
    }
}