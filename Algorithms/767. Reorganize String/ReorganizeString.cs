//Author: Tushar Jaiswal
//Creation Date: 08/19/2018

/*Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
If possible, output any possible result.  If not possible, return the empty string.

Example 1:
Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note: S will consist of lowercase letters and have length in range [1, 500].*/

public class Solution {
    public string ReorganizeString(string S) {
        Dictionary<char, int> map = new Dictionary<char, int>();
        foreach(char c in S)
        { 
            if(map.ContainsKey(c))
            { map[c]++; }
            else
            { map.Add(c, 1); }
        }
        
        SortedList<int, char> list = new SortedList<int, char>(new DuplicateKeyComparer<int>());
        foreach(KeyValuePair<char, int> kvp in map)
        { list.Add(kvp.Value, kvp.Key); }
        
        StringBuilder sb = new StringBuilder();
        while(list.Count > 0)
        {
            int freqA = list.Keys[0];
            char valA = list.Values[0];
            list.RemoveAt(0);
            if(sb.Length == 0 || sb[sb.Length - 1] != valA)
            {
                sb.Append(valA);
                freqA--;
                if(freqA > 0)
                { list.Add(freqA, valA); }
            }
            else if(list.Count > 0)
            {
                int freqB = list.Keys[0];
                char valB = list.Values[0];
                list.RemoveAt(0);
                sb.Append(valB);
                freqB--;
                if(freqB > 0)
                { list.Add(freqB, valB); }
                list.Add(freqA, valA);
            }
            else
            { return ""; }
        }
        return sb.ToString();
    }
}

class DuplicateKeyComparer<TKey> : IComparer<TKey> where TKey : IComparable
{
    public int Compare(TKey a, TKey b)
    {
        int result = b.CompareTo(a);
        return result == 0 ? 1 : result;
    }
}