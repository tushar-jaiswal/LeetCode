//Author: Tushar Jaiswal
//Creation Date: 11/22/2020

/*Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
*/

/*Runtime Complexity: O(n)
Space Complexity: O(n)*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int currSum = 0;

        var sumFreqMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            currSum += num;
            if (currSum == k) {
                result++;
            }
            if (sumFreqMap.containsKey(currSum - k)) {
                result += sumFreqMap.get(currSum - k);
            }
            sumFreqMap.merge(currSum, 1, Integer::sum);
        }

        return result;
    }
}

// 3, 1, 3, -1 , 1, -1
// 3, 4, 7, 6, 7, 6
