//Author: Tushar Jaiswal
//Creation Date: 07/13/2016
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int p1=0, p2=0, sum, maxP1=0, maxP2=0, maxSum;
        
        if(nums.length == 0)
        {
            return 0;
        }
        
        boolean restartSum = true;
        sum = 0;
        maxSum = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(restartSum)
            {
                sum = 0;
            }
            sum += nums[i];
            
            if((sum < sum - nums[i]) && (sum < 0))
            {
                if((i + 1) < nums.length)
                {
                    p1 = i + 1;
                    p2 = i + 1;
                    restartSum = true;
                }
            }
            else
            {
                p2 = i;
                restartSum = false;
            }
            
            if(sum > maxSum)
            {
                maxSum = sum;
                maxP1 = p1;
                maxP2 = p2;
            }
            if(nums[i] > maxSum)
            {
                maxSum = nums[i];
                maxP1 = i;
                maxP2 = i;
                p1 = i;
                p2 = i;
            }
        }
        
        return maxSum;
    }
}