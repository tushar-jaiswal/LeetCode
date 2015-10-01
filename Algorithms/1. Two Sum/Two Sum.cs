//Author: Tushar Jaiswal
//Creation Date: 09/30/2015

/*Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
Input: numbers={-3,4,3,90}, target=0
Output: index1=1, index2=3*/

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        if(nums.Length == 2)
        {
            return new int[]{1, 2};
        }
        else
        {
            int index;
            Dictionary<int, int> inputIntegers = new Dictionary<int, int>();
            for (int i = 0; i <nums.Length; i++)//Add all valid integers to a dictionary except two same numbers
            {
                try
                {
                    inputIntegers.Add(nums[i], i);
                }
                catch (Exception ex)
                {
                    if(inputIntegers.TryGetValue(nums[i], out index))//If this number has already been added to dictionary, check to see if adding these two numbers gets us the target
                    {
                        if(index != i && nums[i]*2 == target)
                        {
                            return(new int[]{index+1, i+1});
                        }
                    }
                }
            }
            
            for (int i=0; i < nums.Length; i++)
            {
                //Check if for the current integer we can find the desired integer amongst the valid integers stored in the dictionary
                if(inputIntegers.TryGetValue((target-nums[i]), out index))
                {
                    if(index != i)//If twice of current number is the target but there isn't any duplicate number in the array, this check prevents false indexes from being returned
                    {
                        return new int[]{i+1, index+1};   
                    }
                }
            }
            
            return null;
        }
    }
}
