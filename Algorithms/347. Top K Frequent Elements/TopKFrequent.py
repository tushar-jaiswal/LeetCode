# Author: Tushar Jaiswal
# Creation Date: 2025-08-03

# Problem Source: https://leetcode.com/problems/top-k-frequent-elements

# Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

# Example 1:
# Input: nums = [1,1,1,2,2,3], k = 2
# Output: [1,2]

# Example 2:
# Input: nums = [1], k = 1
# Output: [1]

# Constraints:
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# k is in the range [1, the number of unique elements in the array].
# It is guaranteed that the answer is unique.

# Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

# Time complexity : O(N+Nlogk) if k<N and O(1) in the particular case of N=k. That ensures time complexity to be better than O(NlogN).
# Space complexity : O(N+k) to store the hash map with not more N elements and a heap with k elements.

import heapq

class Element:
    def __init__(self, val: int, frequency: int):
        self.val = val
        self.frequency = frequency
    
    def __lt__(self, other):
        return self.frequency < other.frequency

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if k == len(nums):
            return nums

        frequency = Counter(nums)
        heap = []

        for val, frequency in frequency.items():
            heapq.heappush(heap, Element(val, frequency))
            if len(heap) > k:
                heapq.heappop(heap)

        return [x.val for x in heap]
