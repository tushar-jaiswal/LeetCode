//Author: Tushar Jaiswal
//Creation Date: 03/15/2018

/*Given an array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

public class Solution {
    public int SingleNumber(int[] nums) {
        int result = 0;
        foreach(int i in nums)
        {
            result ^= i;
        }
        return result;
    }
}