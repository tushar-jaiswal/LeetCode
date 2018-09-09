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

public class Solution {
    public IList<IList<int>> PermuteUnique(int[] nums) {
        List<int> list = new List<int>();
        foreach(int i in nums)
        { list.Add(i); }
        IList<IList<int>> result = new List<IList<int>>();
        FindPermutations(list, new List<int>(), result);
        return result;
    }
    
    public void FindPermutations(List<int> nums, List<int> curr, IList<IList<int>> result)
    {
        if(nums.Count == 0)
        { result.Add(curr); }
        HashSet<int> set = new HashSet<int>();
        foreach(int i in nums)
        {
            if(!set.Contains(i))
            {
                set.Add(i);
                List<int> newCurr = new List<int>(curr);
                List<int> newNums = new List<int>(nums);
                newCurr.Add(i);
                newNums.Remove((int)i);
                FindPermutations(newNums, newCurr, result);
            }
        }
    }
}