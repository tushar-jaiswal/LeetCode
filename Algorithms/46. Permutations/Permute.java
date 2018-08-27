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

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums)
        { list.add(i); }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getPermutations(result, list, new ArrayList<Integer>());
        return result;
    }
    
    private void getPermutations(List<List<Integer>> result, List<Integer> nums, List<Integer> curr)
    {
        if(nums.size() == 0)
        { result.add(curr); }
        
        for(int i : nums)
        {
            List<Integer> newCurr = new ArrayList<Integer>(curr);
            List<Integer> newNums = new ArrayList<Integer>(nums);
            newCurr.add(i);
            newNums.remove((Integer)i);
            getPermutations(result, newNums, newCurr);
        }
    }
}