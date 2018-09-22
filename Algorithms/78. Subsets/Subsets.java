//Author: Tushar Jaiswal
//Creation Date: 09/18/2018

/*Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result)
    {
        result.add(list);
        for(int i = start; i < nums.length; i++)
        {
            List<Integer> newList = new ArrayList<Integer>(list);
            list.add(nums[i]);
            backtrack(nums, i + 1, newList, result);
        }
    }
}