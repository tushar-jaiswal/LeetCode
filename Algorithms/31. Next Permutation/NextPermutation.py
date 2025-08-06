# Author: Tushar Jaiswal
# Creation Date: 2025-08-05

# Problem Source: https://leetcode.com/problems/next-permutation

# A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

# For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
# The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

# For example, the next permutation of arr = [1,2,3] is [1,3,2].
# Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
# While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
# Given an array of integers nums, find the next permutation of nums.

# The replacement must be in place and use only constant extra memory.

# Example 1:
# Input: nums = [1,2,3]
# Output: [1,3,2]

# Example 2:
# Input: nums = [3,2,1]
# Output: [1,2,3]

# Example 3:
# Input: nums = [1,1,5]
# Output: [1,5,1]

# Constraints:
# 1 <= nums.length <= 100
# 0 <= nums[i] <= 100

# Runtime complexity: O(n)
# Space complexity: O(n)

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 2
        while i >= 0 and nums[i + 1] <= nums[i]: # Find index where num at index is lower than next index
            i -= 1
        # Find number in the right array where its value is just larger than discoverd index
        # Don't need to do it if entire array is in decreasng order
        if i >= 0:
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j-= 1

            #Swap with the larger element to get smallest next higher number in permutation.
            # Now array to the right of i is in decreasing order
            self.swap(nums, i, j) 
    
        # Flip array to the right to make it increasing order for smaller lexicographic order
        self.reverse(nums, i + 1)
    
    def swap(self, nums: List[int], a: int, b: int) -> None:
        nums[a], nums[b] = nums[b], nums[a]
    
    def reverse(self, nums: List[int], start: int) -> None:
        i = start
        j = len(nums) - 1
        while i < j:
            self.swap(nums, i, j)
            i += 1
            j -=1
