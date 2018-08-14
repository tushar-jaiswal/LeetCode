//Author: Tushar Jaiswal
//Creation Date: 08/13/2018

/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two different characters.*/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray())
        { 
            if(map.containsKey(c))
            { map.put(c, map.get(c) + 1); }
            else
            { map.put(c, 1); }
        }
        
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(Character c : map.keySet())
        {
            int frequency = map.get(c);
            if(buckets[frequency] == null)
            { buckets[frequency] = new ArrayList<Character>(); }
            buckets[frequency].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1; i > 0; i--)
        {
            if(buckets[i] != null)
            {
                for(Character c : buckets[i])
                {
                    for(int j = 0; j < i; j++)
                    { sb.append(c); }
                }
            }
        }
        return sb.toString();
    }
}