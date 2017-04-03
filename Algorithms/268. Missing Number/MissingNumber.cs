//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
For example,
Given nums = [0, 1, 3] return 2.
Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/

public class Solution {
    public int MissingNumber(int[] nums) {
        int sum = 0;
        foreach(int i in nums)
        {
            sum += i;
        }
        int desiredSum = nums.Length * (nums.Length + 1) / 2;
        return desiredSum - sum;
    }
}