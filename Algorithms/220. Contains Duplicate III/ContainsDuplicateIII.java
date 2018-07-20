//Author: Tushar Jaiswal
//Creation Date: 07/19/2018

/*Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 1 || t < 0)
        { return false; }
            
        TreeSet<Long> bucket = new TreeSet<Long>();
        bucket.add((long)nums[0]);
        for(int i = 1; i < nums.length; i++)
        {
            Long floor = bucket.floor((long)nums[i] + t);
            Long ceiling = bucket.ceiling((long)nums[i] - t);
            
            if((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i]))
            { return true; }
            if(i >= k)
            { bucket.remove((long)nums[i - k]); }
            bucket.add((long)nums[i]);
        }
        return false;
    }
}