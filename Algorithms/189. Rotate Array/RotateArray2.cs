//Author: Tushar Jaiswal
//Creation Date: 08/04/2016

/*Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.*/

public class Solution {
    public void Rotate(int[] nums, int k) {
        k = k % nums.Length;
        int[] result = new int[nums.Length];
        
        for(int i = 0; i < nums.Length; i++)
        {
            if(i < k)
            { 
                result[i] = nums[nums.Length - k + i];
            }
            else
            {
                result[i] = nums[i - k];
            }
        }
        
        for(int i = 0; i < nums.Length; i++)
        {
            nums[i] = result[i];
        }
    }
}