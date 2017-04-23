//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: 
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> unique1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> intersection = new HashMap<Integer, Integer>();
        
        for(int i : nums1)
        {
            unique1.put(i,1);
        }
        
        for(int i : nums2)
        {
            if(unique1.containsKey(i))
            { intersection.put(i, 1); }
        }
        Set<Integer> keys = intersection.keySet();
        int[] result = new int[keys.size()];
        int index = 0;
        for(Integer i : keys)
        {
            result[index++] = i.intValue();
        }
        return result;
    }
}