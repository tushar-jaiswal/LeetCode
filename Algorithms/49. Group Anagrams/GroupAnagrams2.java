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
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs)
        {
            int[] count = new int[26];
            for(char c : str.toCharArray())
            { count[c - 'a']++; }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++)
            {
                for(int j = 0; j < count[i]; j++)
                { sb.append((char)('a' + i)); }
            }
            String sorted = sb.toString();
            if(!map.containsKey(sorted))
            { map.put(sorted, new ArrayList<String>());  }
            map.get(sorted).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
} 