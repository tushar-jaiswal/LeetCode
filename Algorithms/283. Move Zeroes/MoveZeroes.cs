//Author: Tushar Jaiswal
//Creation Date: 04/05/2017

/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note: 1. You must do this in-place without making a copy of the array. 2. Minimize the total number of operations.*/

public class Solution {
    public void MoveZeroes(int[] nums) {
        for(int posZero = 0, posNonZero = 0; posZero < nums.Length && posNonZero < nums.Length;)
        {
            while(posZero < nums.Length && nums[posZero] != 0)
            { posZero++; }
            posNonZero = posZero;
            while(posNonZero < nums.Length && nums[posNonZero] == 0)
            { posNonZero++; }
            if(posZero >= nums.Length || posNonZero >= nums.Length)
            { break; }
            nums[posZero] = nums[posNonZero];
            nums[posNonZero] = 0;
            posZero++;
            posNonZero++;
        }
    }
}