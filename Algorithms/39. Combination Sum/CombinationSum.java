//Author: Tushar Jaiswal
//Creation Date: 02/28/2019

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

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void helper(int[] candidates, int target, int pos, List<Integer> combination, List<List<Integer>> result)
    {
        for(int i = pos; i < candidates.length; i++)
        {
            List<Integer> curr = new ArrayList<Integer>(combination);
            curr.add(candidates[i]);
            if(target - candidates[i] == 0)
            {
                result.add(curr);
            }
            else if(target - candidates[i] > 0)
            {
                helper(candidates, target - candidates[i], i, curr, result);
            }
            else
            { break; }
        }
    }
}
