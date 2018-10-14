//Author: Tushar Jaiswal
//Creation Date: 10/14/2018

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?*/

public class Solution {
    public int LengthOfLIS(int[] nums) {
        if(nums == null || nums.Length == 0)
        { return 0; }
        int largest = 1;
        int[] longestAt = new int[nums.Length];
        longestAt[0] = 1;
        for(int i = 1; i < nums.Length; i++)
        {
            int currMax = 0;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    currMax = Math.Max(currMax, longestAt[j]);
                }
            }
            longestAt[i] = currMax + 1;
            largest = Math.Max(largest, longestAt[i]);
        }
        return largest;
    }
}