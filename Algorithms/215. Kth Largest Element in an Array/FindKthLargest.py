# Author: Tushar Jaiswal
# Creation Date: 2025-08-02

# Problem Source: https://leetcode.com/problems/kth-largest-element-in-an-array

# Given an integer array nums and an integer k, return the kth largest element in the array.
# Note that it is the kth largest element in the sorted order, not the kth distinct element.
# Can you solve it without sorting?

# Example 1:
# Input: nums = [3,2,1,5,6,4], k = 2
# Output: 5

# Example 2:
# Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
# Output: 4

# Constraints:
# 1 <= k <= nums.length <= 105
# -10^4 <= nums[i] <= 10^4

# Runtime Complexity: O(n log(n))
# Time complexity: O(n) on average, O(n^2) in the worst case. 
  # Each call we make to quickSelect will cost O(n) since we need to iterate over nums to create left, mid, and right. 
  # The number of times we call quickSelect is dependent on how the pivots are chosen. 
  # The worst pivots to choose are the extreme (greatest/smallest) ones because they reduce our search space by the least amount. 
  # Because we are randomly generating pivots, we may end up calling quickSelect O(n) times, leading to a time complexity of O(n^2).
  # However, the algorithm mathematically almost surely has a linear runtime. 
  # For any decent size of nums, the probability of the pivots being chosen in a way that we need to call quickSelect O(n) times is so low that we can ignore it.
  # On average, the size of nums will decrease by a factor of ~2 on each call. 
  # You may think: that means we call quickSelect O(logn) times, wouldn't that give us a time complexity of O(n⋅logn)? 
  # Well, each successive call to quickSelect would also be on a nums that is a factor of ~2 smaller. This recurrence can be analyzed using the master theorem with a = 1, b = 2, k = 1:
  # T(n)=T(n/2)+O(n)=O(n)
# Space Complexity: O(1)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            pivot = random.randint(low, high)
            self.swap(nums, high, pivot)

            i = low - 1
            for j in range(low, high):
                if nums[j] <= nums[high]:
                    i += 1
                    self.swap(nums, i, j)
            self.swap(nums, i + 1, high)

            if i + 1 == len(nums) - k:
                return nums[i + 1]
            elif len(nums) - k > i + 1:
                low = i + 2
            else:
                high = i
        
        return -1

    def swap(self, nums, a, b):
        nums[a], nums[b] = nums[b], nums[a]
