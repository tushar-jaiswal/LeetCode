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
    public int thirdMax(int[] nums) {
        int i;
        List<Integer> firstNums = new ArrayList<Integer>();
        
        firstNums.add(nums[0]);
        
        for(i = 1; i < nums.length; i++)
        {
            if(firstNums.size() == 2)
            {
                if(nums[i] != firstNums.get(0) && nums[i] != firstNums.get(1))
                {
                    firstNums.add(nums[i]);
                    break;
                }
            }
            else
            {
                if(nums[i] != firstNums.get(0))
                {
                    firstNums.add(nums[i]);
                }
            }
        }
        
        Collections.sort(firstNums, Collections.reverseOrder());
        
        if(firstNums.size() != 3)
        {
            return firstNums.get(0);
        }
        
        for(;i < nums.length; i++)
        {
            if(nums[i] != firstNums.get(0) && nums[i] != firstNums.get(1) && nums[i] != firstNums.get(2))
            {
                if(nums[i] >  firstNums.get(2))
                {
                    if(nums[i] > firstNums.get(1))
                    {
                        if(nums[i] > firstNums.get(0))
                        {
                            firstNums.set(2, firstNums.get(1));
                            firstNums.set(1, firstNums.get(0));
                            firstNums.set(0, nums[i]);
                        }
                        else
                        {
                            firstNums.set(2, firstNums.get(1));
                            firstNums.set(1, nums[i]);
                        }
                    }
                    else
                    {
                        firstNums.set(2, nums[i]);
                    }
                }
            }
        }
        
        return firstNums.get(2);
    }
}