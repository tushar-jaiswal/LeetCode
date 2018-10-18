//Author: Tushar Jaiswal
//Creation Date: 10/18/2018


/*Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:
Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:You may assume all input has valid answer.

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?*/

class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int num : nums)
        {
            heap.offer(num);
        }
        for(int i = 1; i < nums.length; i+=2)
        {
            nums[i] = heap.poll();
        }
        for(int i = 0; i < nums.length; i+=2)
        {
            nums[i] = heap.poll();
        }
    }
}