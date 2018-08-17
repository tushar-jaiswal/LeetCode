//Author: Tushar Jaiswal
//Creation Date: 08/17/2018

/*Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input: nums = [1,3,1] k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int low = 0, high = nums[len - 1] - nums[0];
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int count = 0;
            int maxDistance = -1;
            for(int start = 0, end = 1; end < len; end++)
            {
                while(nums[end] - nums[start] > mid)
                { start++; }
                if(start < end)
                {
                    count += end - start; 
                    maxDistance = Math.max(maxDistance, nums[end] - nums[start]);
                }
            }
            if(count == k)
            { return maxDistance; }
            if(count < k)
            { low = mid + 1; }
            else
            { high = mid - 1; }
        }
        return low;
    }
}