//Author: Tushar Jaiswal
//Creation Date: 12/14/2020

/*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
*/

/*Runtime Complexity: O(log(n))
Space Complexity: O(1)*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = binarySearch(nums, target, 0, nums.length - 1, true);
        if (left == -1) {
            return result;
        } else {
            result[0] = left;
        }
        result[1] = binarySearch(nums, target, left, nums.length -1, false);

        return result;
    }

    private int binarySearch(int[] nums, int target, int left, int right, boolean isLeftSearch) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isLeftSearch) {
                mid++;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (isLeftSearch) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isLeftSearch && right >= 0) {
            return nums[right] == target ? right : -1;
        } else if (left < nums.length) {
            return nums[left] == target ? left : -1;
        } else {
            return -1;
        }
    }
}
