//Author: Tushar Jaiswal
//Creation Date: 09/13/2020

/*Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Follow up: Your algorithm should run in O(n) time and uses constant extra space.*/

/*Runtime Complexity: O(n)
Space Complexity: O(1)*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //If number points to another position in array, set it at that position if it isn't the same number.
            //Also set other numbers at their respective positions if needed.
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static final void swap(final int[] nums, final int a, final int b) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
