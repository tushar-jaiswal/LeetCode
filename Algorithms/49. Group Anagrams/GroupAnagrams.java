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
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(!map.containsKey(sorted))
            { map.put(sorted, new ArrayList<String>());  }
            map.get(sorted).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}