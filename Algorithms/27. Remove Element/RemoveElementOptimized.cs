//Author: Tushar Jaiswal
//Creation Date: 06/12/2016
/*Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.*/
public class Solution {
    public int RemoveElement(int[] nums, int val) {
        int i, removed = 0;
        for(i=0; i<nums.Length; i++)
        {
           while(nums[i] == val && nums.Length-1-removed >= i)
           {
               nums[i] = nums[nums.Length-1-removed];
               removed++;
           }
        }
        return nums.Length-removed;
    }
}