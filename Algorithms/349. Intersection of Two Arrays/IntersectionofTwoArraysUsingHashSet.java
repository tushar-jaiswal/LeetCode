//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: 
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> unique1 = new HashSet<Integer>();
        HashSet<Integer> intersection = new HashSet<Integer>();
        
        for(int i : nums1)
        {
            unique1.add(i);
        }
        
        for(int i : nums2)
        {
            if(unique1.contains(i))
            { intersection.add(i); }
        }
        
        int[] result = new int[intersection.size()];
        int index = 0;
        for(Integer i : intersection)
        {
            result[index++] = i.intValue();
        }
        return result;
    }
}