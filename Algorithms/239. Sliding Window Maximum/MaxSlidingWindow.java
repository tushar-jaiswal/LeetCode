//Author: Tushar Jaiswal
//Creation Date: 12/27/2020

/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,-1], k = 1
Output: [1,-1]

Example 4:
Input: nums = [9,11], k = 2
Output: [11]

Example 5:
Input: nums = [4,-2], k = 2
Output: [4]

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
*/

/*Runtime Complexity: O(n)
Space Complexity: O(max(k, nums.length - k)) = O(n)*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("k must not be greater than size of the input array.");
        }
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            cleanDeque(deque, nums, i, k);
            deque.add(i);

            if (i >= k - 1) {
                result[i - (k - 1)] = nums[deque.peek()];
            }
        }

        return result;
    }

    private void cleanDeque(Deque<Integer> deque, int[] nums, int i, int k) {
        // Remove elements from before the current window
        if (!deque.isEmpty() && deque.peek() == i - k) {
            deque.remove();
        }

        // Remove elements smaller than or equal to the current number as they are not max.
        // This would allow us to keep the max number in window at the head of the deque.
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.removeLast();
        }
    }
}
