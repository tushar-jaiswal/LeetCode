//Author: Tushar Jaiswal
//Creation Date: 02/24/2017

/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        
        for(int i=0; i < nums.length; i++)
        {
            if(elements.containsKey(nums[i]))
            {
                if(Math.abs(elements.get(nums[i]) - i) <= k)
                { return true; }
                else
                {
                    elements.replace(nums[i], i);
                }
            }
            else
            {
                elements.put(nums[i], i);
            }
        }
        return false;
    }
}