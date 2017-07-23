//Author: Tushar Jaiswal
//Creation Date: 07/23/2017

/*Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: [1, 2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.*/

public class Solution {
    public int ThirdMax(int[] nums) {
        int i;
        List<int> firstNums = new List<int>();
        
        firstNums.Add(nums[0]);
        
        for(i = 1; i < nums.Length; i++)
        {
            if(firstNums.Count == 2)
            {
                if(nums[i] != firstNums[0] && nums[i] != firstNums[1])
                {
                    firstNums.Add(nums[i]);
                    break;
                }
            }
            else
            {
                if(nums[i] != firstNums[0])
                {
                    firstNums.Add(nums[i]);
                }
            }
        }
        
        firstNums.Sort((a, b) => b.CompareTo(a));
        
        if(firstNums.Count != 3)
        {
            return firstNums[0];
        }
        
        for(;i < nums.Length; i++)
        {
            if(nums[i] != firstNums[0] && nums[i] != firstNums[1] && nums[i] != firstNums[2])
            {
                if(nums[i] >  firstNums[2])
                {
                    if(nums[i] > firstNums[1])
                    {
                        if(nums[i] > firstNums[0])
                        {
                            firstNums[2] = firstNums[1];
                            firstNums[1] = firstNums[0];
                            firstNums[0] = nums[i];
                        }
                        else
                        {
                            firstNums[2] = firstNums[1];
                            firstNums[1] = nums[i];
                        }
                    }
                    else
                    {
                        firstNums[2] = nums[i];
                    }
                }
            }
        }
        
        return firstNums[2];
    }
}