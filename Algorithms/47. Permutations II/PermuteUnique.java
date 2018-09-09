//Author: Tushar Jaiswal
//Creation Date: 09/09/2018

/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums)
        { list.add(i); }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findPermutations(list, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void findPermutations(List<Integer> nums, List<Integer> curr, List<List<Integer>> result)
    {
        if(nums.size() == 0)
        { result.add(curr); }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums)
        {
            if(!set.contains(i))
            {
                set.add(i);
                List<Integer> newCurr = new ArrayList<Integer>(curr);
                List<Integer> newNums = new ArrayList<Integer>(nums);
                newCurr.add(i);
                newNums.remove((Integer)i);
                findPermutations(newNums, newCurr, result);
            }
        }
    }
}