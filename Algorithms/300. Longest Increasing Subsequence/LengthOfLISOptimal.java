//Author: Tushar Jaiswal
//Creation Date: 10/15/2018

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
        { return 0; }
        int length = 0;
        int[] dp = new int[nums.length];
        for(int num : nums)
        {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if(i < 0)
            {
                i = -(i + 1);
            }
            dp[i] = num;
            if(i == length)
            {
                length++;
            }
        }
        return length;
    }
}