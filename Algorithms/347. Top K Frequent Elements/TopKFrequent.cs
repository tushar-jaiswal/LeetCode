//Author: Tushar Jaiswal
//Creation Date: 08/14/2018

/*Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note: You may assume k is always valid, 1 = k = number of unique elements. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

public class Solution {
    public IList<int> TopKFrequent(int[] nums, int k) {
        Dictionary<int, int> map = new Dictionary<int, int>();
        foreach(int i in nums)
        {
            if(map.ContainsKey(i))
            { map[i] += 1; }
            else
            { map[i] = 1; }
        }
        
        List<int>[] buckets = new List<int>[nums.Length + 1];
        foreach(int i in map.Keys)
        {
            int frequency = map[i];
            if(buckets[frequency] == null)
            { buckets[frequency] = new List<int>(); }
            buckets[frequency].Add(i);
        }
        
        List<int> result = new List<int>();
        for(int i = nums.Length; i > 0; i--)
        {
            if(buckets[i] != null)
            {
                foreach(int j in buckets[i])
                {
                    result.Add(j);
                    if(result.Count == k)
                    { return result; }
                }
            }
        }
        return result;
    }
}