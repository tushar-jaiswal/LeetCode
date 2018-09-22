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

public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        Backtrack(nums, 0, new List<int>(), result);
        return result;
    }
    
    public void Backtrack(int[] nums, int start, List<int> list, IList<IList<int>> result)
    {
        result.Add(list);
        for(int i = start; i < nums.Length; i++)
        {
            List<int> newList = new List<int>(list);
            list.Add(nums[i]);
            Backtrack(nums, i + 1, newList, result);
        }
    }
}