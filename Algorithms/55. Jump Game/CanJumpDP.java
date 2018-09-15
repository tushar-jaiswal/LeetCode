//Author: Tushar Jaiswal
//Creation Date: 09/15/2018

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.*/

class Solution {
    public boolean canJump(int[] nums) {
        int[] validPositions = new int[nums.length];
        return canJumpHelper(nums, 0, validPositions);
    }
    
    public boolean canJumpHelper(int[] nums, int index, int[] validPositions) {
        if(index == nums.length - 1)
        { return true; }
        for(int jump = Math.min(nums[index], nums.length - 1 - index); jump > 0 && validPositions[index + jump] != -1; jump--) {
            if(canJumpHelper(nums, index + jump, validPositions))
            { return true; }
        }
        validPositions[index] = -1;
        return false;
    }
}