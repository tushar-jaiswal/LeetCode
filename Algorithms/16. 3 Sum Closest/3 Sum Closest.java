//Author: Tushar Jaiswal
//Creation Date: 10/03/2015

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
Input: 
S=[0,0,0] & target=1
Output: 0
S=[-1,2,1,-4] & target=1
Output: 2
S=[-3,0,1,2] & target=1
Output: 0
*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum=0;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++)
        {
            int j = i+1;
            int k = nums.length-1;
            int optimalTwoSum = target-nums[i];
            
            if(i == 0)
            {
                closestSum = nums[i] + nums[j] + nums[k];
            }
            
            if(i > 0 && nums[i] == nums[i-1])//Avoid duplicate values
            { continue; }
            
            while(j < k)
            {
                int twoSum = nums[j] + nums[k];
                if(twoSum == optimalTwoSum)
                { return target;}
                else if(Math.abs(optimalTwoSum - twoSum) < Math.abs(target - closestSum))
                {
                    closestSum = nums[i] + twoSum;
                }
                if(twoSum < optimalTwoSum)
                { j++; }
                else 
                if(twoSum > optimalTwoSum)
                { k--; }
            }
        }
        return closestSum;
    }
}