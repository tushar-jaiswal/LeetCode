//Author: Tushar Jaiswal
//Creation Date: 02/08/2019

/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/

public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        int target = 0;
        Array.Sort(nums);
        IList<IList<int>> result = new List<IList<int>>();

        for(int i = 0; i < nums.Length - 2; i++)
        {
            int twoSum = target - nums[i];
            int left = i + 1;
            int right = nums.Length - 1;

            if(i > 0 && nums[i - 1] == nums[i])
            { continue; }

            while(left < right)
            {
                int sum = nums[left] + nums[right];
                if(sum == twoSum)
                {
                    result.Add(new List<int>(new int[]{nums[i], nums[left], nums[right]}));
                    do
                    {
                        left++;
                    }while(left < right && nums[left] == nums[left - 1]);
                    do
                    {
                        right--;
                    }while(left < right && nums[right] == nums[right + 1]);
                }
                else if(sum < twoSum)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }
}
