//Author: Tushar Jaiswal
//Creation Date: 04/23/2017

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: 
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersection = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;)
        {
            if(nums1[i] < nums2[j])
            { i++; }
            else if(nums1[i] > nums2[j])
            { j++; }
            else
            {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
            
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