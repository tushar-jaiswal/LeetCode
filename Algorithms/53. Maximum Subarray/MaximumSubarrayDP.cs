//Author: Tushar Jaiswal
//Creation Date: 07/17/2016

/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public class Solution {
    public int MaxSubArray(int[] nums) {
        if(nums.Length == 0)
        { return 0; }
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.Length; i++)
        {
            sum = Math.Max(nums[i], sum + nums[i]);
            maxSum = Math.Max(sum, maxSum);
        }
        return maxSum;
    }
}