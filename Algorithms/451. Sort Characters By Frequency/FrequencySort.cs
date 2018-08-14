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

public class Solution {
    public string FrequencySort(string s) {
        Dictionary<char, int> map = new Dictionary<char, int>();
        foreach(char c in s)
        { 
            if(map.ContainsKey(c))
            { map[c]++; }
            else
            { map[c] = 1; }
        }
        
        List<char>[] buckets = new List<char>[s.Length + 1];
        foreach(char c in map.Keys)
        {
            int frequency = map[c];
            if(buckets[frequency] == null)
            { buckets[frequency] = new List<char>(); }
            buckets[frequency].Add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.Length - 1; i >= 0; i--)
        {
            if(buckets[i] != null)
            {
                foreach(char c in buckets[i])
                {
                    for(int j = 0; j < i; j++)
                    { sb.Append(c); }
                }
            }
        }
        return sb.ToString();
    }
}