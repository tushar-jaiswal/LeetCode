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

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums)
        {
            if(map.containsKey(i))
            { map.put(i, map.get(i) + 1) ;}
            else
            { map.put(i, 1); }
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int i : map.keySet())
        {
            int frequency = map.get(i);
            if(buckets[frequency] == null)
            { buckets[frequency] = new ArrayList<Integer>(); }
            buckets[frequency].add(i);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = nums.length; i > 0; i--)
        {
            if(buckets[i] != null)
            {
                for(int j : buckets[i])
                {
                    result.add(j);
                    if(result.size() == k)
                    { return result; }
                }
            }
        }
        return result;
    }
}