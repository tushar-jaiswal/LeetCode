# Author: Tushar Jaiswal
# Creation Date: 2025-08-05

# Problem Source: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

# Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

# If target is not found in the array, return [-1, -1].

# You must write an algorithm with O(log n) runtime complexity.

# Example 1:
# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]

# Example 2:
# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

# Example 3:
# Input: nums = [], target = 0
# Output: [-1,-1]

# Constraints:
# 0 <= nums.length <= 10^5
# -10^9 <= nums[i] <= 10^9
# nums is a non-decreasing array.
# -10^9 <= target <= 10^9

# Runtime complexity: O(log n)
# Space complexity: O(1) 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start, end = 0, len(nums) - 1
        left = right = -1

        while (start <= end):
            mid = start + (end - start) // 2
            if nums[mid] == target and (mid == 0 or nums[mid - 1] != target):
                left = mid
                break
            elif nums[mid] > target or nums[mid] == target:
                end = mid - 1
            elif nums[mid] < target:
                start = mid + 1

        start, end = 0, len(nums) - 1
        while (start <= end):
            mid = start + (end - start) // 2
            if nums[mid] == target and (mid + 1 == len(nums) or nums[mid + 1] != target):
                right = mid
                break
            elif nums[mid] < target or nums[mid] == target:
                start = mid + 1
            elif nums[mid] > target:
                end = mid - 1

        return [left, right]
