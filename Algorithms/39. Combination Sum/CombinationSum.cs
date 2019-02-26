//Author: Tushar Jaiswal
//Creation Date: 02/25/2019

/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

public class Solution {
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        Array.Sort(candidates);
        IList<IList<int>> result = new List<IList<int>>();
        Helper(candidates, target, 0, new List<int>(), result);
        return result;
    }

    public void Helper(int[] candidates, int target, int pos, List<int> combination, IList<IList<int>> result)
    {
        for(int i = pos; i < candidates.Length; i++)
        {
            List<int> curr = new List<int>(combination);
            curr.Add(candidates[i]);
            if(target - candidates[i] == 0)
            {
                result.Add(curr);
            }
            else if(target - candidates[i] > 0)
            {
                Helper(candidates, target - candidates[i], i, curr, result);
            }
            else
            { break; }
        }
    }
}
