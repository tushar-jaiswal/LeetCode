//Author: Tushar Jaiswal
//Creation Date: 08/04/2016

/*Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.*/

public class Solution {
    public void Rotate(int[] nums, int k) {
        k = k % nums.Length;
        List<int> lastElem = new List<int>();
        for(int i = 1; i <= k; i++)
        {
            lastElem.Add(nums[nums.Length - i]);
        }
        
        for(int i = nums.Length - 1; i >= 0; i--)
        {
            int index = i - k;
            if(index < 0)
            {
                index = -index;
                nums[i] = lastElem[index - 1];
            }
            else
            {
                nums[i] = nums[index];
            }
        }
    }
}