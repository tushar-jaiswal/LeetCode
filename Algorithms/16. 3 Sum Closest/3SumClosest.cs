//Author: Tushar Jaiswal
//Creation Date: 02/08/2019

/*Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

public class Solution {
    public int ThreeSumClosest(int[] nums, int target) {
        Array.Sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.Length - 2; i++)
        {
            int left = i + 1;
            int right = nums.Length - 1;

            if(i > 0 && nums[i - 1] == nums[i])
            { continue; }

            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)
                {
                    return sum;
                }
                if(Math.Abs(target - sum) < Math.Abs(target - closest))
                {
                    closest = sum;
                }
                if(sum < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return closest;
    }
}
