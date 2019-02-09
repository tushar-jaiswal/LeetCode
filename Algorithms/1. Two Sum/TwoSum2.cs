//Author: Tushar Jaiswal
//Creation Date: 02/08/2019

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        dict[nums[0]] = 0;
        for(int i = 1; i < nums.Length; i++)
        {
            if(dict.ContainsKey(target - nums[i]))
            {
                return new int[]{dict[target - nums[i]], i};
            }
            dict[nums[i]] = i;
        }
        return new int[]{};
    }
}
