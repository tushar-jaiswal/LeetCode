//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

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
        if(nums1.Length < nums2.Length)
        { return IntersectionHelper(nums1, nums2); }
        else
        { return IntersectionHelper(nums2, nums1); }
    }
    
    private int[] IntersectionHelper(int[] smallNums, int[] largeNums)
    {   
        List<int> intersection = new List<int>();
        Array.Sort(smallNums);
        
        Dictionary<int, int> countUnfoundNums = new Dictionary<int, int>();
        foreach(int i in smallNums)
        {
            if(countUnfoundNums.ContainsKey(i))
            { countUnfoundNums[i]++; }
            else
            { countUnfoundNums[i] = 1; }
        }
        
        foreach(int i in largeNums)
        {
            if(BinarySearch(i, smallNums))
            { 
                if(countUnfoundNums[i] > 0)
                { 
                    intersection.Add(i); 
                    countUnfoundNums[i]--;
                }
            }
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