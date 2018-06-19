//Author: Tushar Jaiswal
//Creation Date: 03/29/2018

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.*/

public class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int target, int left, int right)
    {
        if(left > right)
        { return -1; }
        
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
        { return mid; }
        
        if(nums[left] <= nums[mid])
        {
            if(target >= nums[left] && target < nums[mid])
            { return helper(nums, target, left, mid - 1);}
            return helper(nums, target, mid + 1, right);
        }
        else
        {
            if(target >= nums[mid + 1] && target <= nums[right])
            { return helper(nums, target, mid + 1, right); }
            return helper(nums, target, left, mid - 1);
        }
    }
}