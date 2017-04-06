//Author: Tushar Jaiswal
//Creation Date: 04/05/2017

/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note: 1. You must do this in-place without making a copy of the array. 2. Minimize the total number of operations.*/

public class Solution {
    public void moveZeroes(int[] nums) {
        for(int posZero = 0, posNonZero = 0; posZero < nums.length && posNonZero < nums.length;)
        {
            while(posZero < nums.length && nums[posZero] != 0)
            { posZero++; }
            posNonZero = posZero;
            while(posNonZero < nums.length && nums[posNonZero] == 0)
            { posNonZero++; }
            if(posZero >= nums.length || posNonZero >= nums.length)
            { break; }
            nums[posZero] = nums[posNonZero];
            nums[posNonZero] = 0;
            posZero++;
            posNonZero++;
        }
    }
}