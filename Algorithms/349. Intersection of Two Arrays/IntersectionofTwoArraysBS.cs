//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: Each element in the result must be unique. The result can be in any order.*/

public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        if(nums1.Length < nums2.Length)
        { return IntersectionHelper(nums1, nums2); }
        else
        { return IntersectionHelper(nums2, nums1); }
    }
    
    private int[] IntersectionHelper(int[] smallNums, int[] largeNums)
    {   
        HashSet<int> intersection = new HashSet<int>();
        Array.Sort(smallNums);
        
        foreach(int i in largeNums)
        {
            if(BinarySearch(i, smallNums))
            { intersection.Add(i); }
        }
        
        return intersection.ToArray();
    }
    
    private bool BinarySearch(int target, int[] nums)
    {
        int low = 0, high = nums.Length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
            { return true; }
            if(target < nums[mid])
            { high = mid - 1; }
            else
            { low = mid + 1; }
        }
        return false;
    }
}