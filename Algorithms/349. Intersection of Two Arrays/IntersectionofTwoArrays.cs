//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: 
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        Dictionary<int, int> unique1 = new Dictionary<int, int>();
        Dictionary<int, int> intersection = new Dictionary<int, int>();
        
        foreach(int i in nums1)
        {
            unique1[i] = 1;
        }
        
        foreach(int i in nums2)
        {
            if(unique1.ContainsKey(i))
            { intersection[i] = 1; }
        }
        int[] result = intersection.Keys.ToArray();
        return result;
    }
}