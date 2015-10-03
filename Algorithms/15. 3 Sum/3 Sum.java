//Author: Tushar Jaiswal
//Creation Date: 10/03/2015

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a = b = c)
The solution set must not contain duplicate triplets.
    Input: [-1,0,1,2,-1,-4]
    Output: [[-1,0,1],[-1,-1,2]]
    
    Input: [0,-4,-1,-4,-2,-3,2,0,0]
    Output:[[-2,0,2],[0,0,0]]*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int target = 0;
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++)
        {
            int twoSum = target-nums[i];
            int j = i+1;
            int k = nums.length-1;
            
            if(i > 0 && nums[i] == nums[i-1]) 
            { continue; }
            
            while(j < k)
            {
                if(twoSum > nums[j] + nums[k])
                { j++; }
                else if(twoSum < nums[j] + nums[k])
                { k--; }
                else
                {
                    triplets.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    
                    //Avoiding duplicates
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])
                    { j++; }
                    while(j<k && nums[k]==nums[k+1])
                    { k--; }
                }
            }
        }
        return triplets;
    }
}