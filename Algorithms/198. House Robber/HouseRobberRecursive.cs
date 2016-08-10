//Author: Tushar Jaiswal
//Creation Date: 08/09/2016

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.*/

public class Solution {
    public int Rob(int[] nums) {
        return MaxSum(0, 0, nums);
    }
    
    public int MaxSum(int sum, int index, int[] nums)
    {
        if(index >= nums.Length)
        {
            return sum; 
        }
        
        if(index + 1 < nums.Length)
        {
            return Math.Max(MaxSum(sum + nums[index], index + 2, nums), MaxSum(sum + nums[index + 1], index + 3, nums));
        }
        else 
        { 
            return sum + nums[index];
        }
    }
}