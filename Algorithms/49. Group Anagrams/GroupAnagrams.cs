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
            char[] arr = str.ToArray();
            Array.Sort(arr);
            string sorted = new string(arr);
            if(!dict.ContainsKey(sorted))
            { dict[sorted] = new List<string>();  }
            dict[sorted].Add(str);
        }
        return new List<IList<string>>(dict.Values);
    }
}