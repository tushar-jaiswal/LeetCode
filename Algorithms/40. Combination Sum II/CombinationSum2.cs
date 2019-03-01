//Author: Tushar Jaiswal
//Creation Date: 02/28/2019

/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/

public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
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
                Helper(candidates, target - candidates[i], i + 1, curr, result);
            }
            else
            { break; }
            while(i + 1 < candidates.Length && candidates[i] == candidates[i + 1])
            { i++; }
        }
    }
}
