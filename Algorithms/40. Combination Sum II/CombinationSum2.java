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

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                helper(candidates, target - candidates[i], i + 1, curr, result);
            }
            else
            { break; }
            while(i + 1 < candidates.length && candidates[i] == candidates[i + 1])
            { i++; }
        }
    }
}
