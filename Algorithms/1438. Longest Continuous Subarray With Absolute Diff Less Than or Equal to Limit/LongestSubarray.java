//Author: Tushar Jaiswal
//Creation Date: 12/25/2020

/*Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Example 1:
Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.

Example 2:
Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.

Example 3:
Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

Constraints:
    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    0 <= limit <= 10^9
*/

/*Runtime Complexity: O(n)
Space Complexity: O(1)*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int min = nums[0];
        int max = nums[0];
        int maxLength = 0;
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (nums[end] >= min && nums[end] <= max) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else if (nums[end] < min) {
                min = nums[end];
                for (int i = start; i <= end; i++) {
                    max = Math.max(max, nums[i]);
                    if (nums[i] - min > limit) {
                        start = i + 1;
                        max = nums[i + 1];
                    }
                }
            } else {
                max = nums[end];
                for (int i = start; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                    if (max - nums[i] > limit) {
                        start = i + 1;
                        min = nums[i + 1];
                    }
                }
            }
        }

        return maxLength;
    }
}
