//Author: Tushar Jaiswal
//Creation Date: 04/02/2018

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.*/

public class Solution {
    public int FindMin(int[] nums) {
        int left = 0, right = nums.Length - 1; 
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1])
            { return nums[mid + 1]; }
            
            if(nums[left] < nums[mid])
            {
                left = mid + 1;
            }
            else
            { right = mid; }
        }
        if(nums.Length != 0) 
        { return nums[0]; }
        else
        { return -1; }
    }
}