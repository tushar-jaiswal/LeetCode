//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/

public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        List<int> list = new List<int>();
        Array.Sort(nums1);
        Array.Sort(nums2);
        
        for(int i = 0, j = 0; i < nums1.Length && j < nums2.Length;)
        {
            if(nums1[i] < nums2[j])
            { i++; }
            else if(nums1[i] > nums2[j])
            { j++; }
            else
            {
                list.Add(nums1[i]);
                i++;
                j++;
            }
            
        }
        
        return list.ToArray();
    }
}