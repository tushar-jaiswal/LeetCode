//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.*/

public class Solution {
    public int FindMin(int[] nums) {
        int low = 0, high = nums.Length - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(mid + 1 < nums.Length && nums[mid] > nums[mid + 1])
            { return nums[mid + 1]; }
            if(nums[mid] > nums[nums.Length - 1])
            { low = mid + 1; }
            else
            { high = mid - 1; }
        }
        return nums[0];
    }
}