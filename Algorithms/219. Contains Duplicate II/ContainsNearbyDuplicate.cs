//Author: Tushar Jaiswal
//Creation Date: 02/24/2017

/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.*/

public class Solution {
    public bool ContainsNearbyDuplicate(int[] nums, int k) {
        Dictionary<int, int> elements = new Dictionary<int, int>();
        
        for(int i=0; i < nums.Length; i++)
        {
            if(elements.ContainsKey(nums[i]))
            {
                if(Math.Abs(elements[nums[i]] - i) <= k)
                { return true; }
                else
                {
                    elements[nums[i]]= i;
                }
            }
            else
            {
                elements.Add(nums[i], i);
            }
        }
        return false;
    }
}