//Author: Tushar Jaiswal
//Creation Date: 02/08/2019

/*Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++)
        {
            if(i > 0 && nums[i - 1] == nums[i])
            { continue; }
            int threeSum = target - nums[i];
            List<List<Integer>> quadruplets = ThreeSum(nums, threeSum, i + 1, nums[i]);
            result.addAll(quadruplets);
        }
        return result;
    }

    public List<List<Integer>> ThreeSum(int[] nums, int target, int start, int item)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = start; i < nums.length - 2; i++)
        {
            if(i > start && nums[i - 1] == nums[i])
            { continue; }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)
                {
                    result.add(Arrays.asList(item, nums[i], nums[left], nums[right]));
                    do
                    {
                        left++;
                    }while(left < right && nums[left - 1] == nums[left]);
                    do
                    {
                        right--;
                    }while(left < right && nums[right] == nums[right + 1]);
                }
                else if(sum < target)
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
