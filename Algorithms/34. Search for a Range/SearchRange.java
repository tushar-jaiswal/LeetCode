//Author: Tushar Jaiswal
//Creation Date: 04/07/2018

/*Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = binarySearchLeft(nums, target);
        range[1] = binarySearchRight(nums, target);
        return range;
    }
    
    public int binarySearchLeft(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while(left + 1 < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
            {
                if(nums[mid - 1] != target)
                { return mid; }
                right = mid - 1;
            }
            else if(target < nums[mid])
            { right = mid - 1; }
            else
            { left = mid + 1; }
        }
        if(left < nums.length && nums[left] == target)
        { return left; }
        if(right >=0 && nums[right] == target)
        { return right; }
        return -1;
    }
    
    public int binarySearchRight(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while(left + 1 < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
            {
                if(nums[mid + 1] != target)
                { return mid; }
                left = mid + 1;
            }
            else if(target < nums[mid])
            { right = mid - 1; }
            else
            { left = mid + 1; }
        }
        if(right >=0 && nums[right] == target)
        { return right; }
        if(left < nums.length && nums[left] == target)
        { return left; }
        return -1;
    }
}