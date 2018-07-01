//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(mid + 1 < nums.length && nums[mid] > nums[mid + 1])
            { return nums[mid + 1]; }
            if(nums[mid] > nums[nums.length - 1])
            { low = mid + 1; }
            else
            { high = mid - 1; }
        }
        return nums[0];
    }
}