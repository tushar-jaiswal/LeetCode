//Author: Tushar Jaiswal
//Creation Date: 08/29/2016

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.*/

public class Solution {
    public int Rob(int[] nums) {
        if(nums == null || nums.Length == 0)
        { return 0; }
        
        if(nums.Length == 1)
        { return nums[0]; }
        
        int[] maxSum = new int[nums.Length];
        maxSum[0] = nums[0];
        maxSum[1] = Math.Max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.Length; i++)
        {
            maxSum[i] = Math.Max(maxSum[i - 2] + nums[i], maxSum[i - 1]);
        }
        return maxSum[nums.Length - 1];
    }
}
