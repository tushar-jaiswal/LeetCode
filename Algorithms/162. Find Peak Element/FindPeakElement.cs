//Author: Tushar Jaiswal
//Creation Date: 04/01/2018

/*A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.*/

public class Solution {
    public int FindPeakElement(int[] nums) {
        for(int i = 0; i < nums.Length - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            { return i; }
        }
        return nums.Length - 1;
    }
}