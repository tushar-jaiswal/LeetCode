//Author: Tushar Jaiswal
//Creation Date: 06/12/2016
/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        if(nums.length == 0)
        { return count; }
        else
        { count = 1;}
        for(int i=0, j=1; i < nums.length-1 && j < nums.length; i++)
        {
            while(j < nums.length && nums[j] == nums[i])
            {
                j++;
            }
            if(j == nums.length)
            { break; }
            nums[i+1] = nums[j++];
            count++;
        }
        
        return count;
    }
}