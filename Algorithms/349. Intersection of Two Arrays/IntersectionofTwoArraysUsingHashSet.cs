//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: 
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        HashSet<int> unique1 = new HashSet<int>();
        HashSet<int> intersection = new HashSet<int>();
        
        foreach(int i in nums1)
        {
            unique1.Add(i);
        }
        
        foreach(int i in nums2)
        {
            if(unique1.Contains(i))
            { intersection.Add(i); }
        }
        int[] result = intersection.ToArray();
        return result;
    }
}