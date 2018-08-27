//Author: Tushar Jaiswal
//Creation Date: 08/26/2018

/*Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/

public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        List<int> list = new List<int>(nums);
        IList<IList<int>> result = new List<IList<int>>();
        GetPermutations(result, list, new List<int>());
        return result;
    }
    
    private void GetPermutations(IList<IList<int>> result, List<int> nums, List<int> curr)
    {
        if(nums.Count == 0)
        { result.Add(curr); }
        
        foreach(int i in nums)
        {
            List<int> newCurr = new List<int>(curr);
            List<int> newNums = new List<int>(nums);
            newCurr.Add(i);
            newNums.Remove(i);
            GetPermutations(result, newNums, newCurr);
        }
    }
}