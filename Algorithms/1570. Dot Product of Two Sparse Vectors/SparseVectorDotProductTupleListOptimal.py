# Author: Tushar Jaiswal
# Creation Date: 2025-08-05

# Problem Source: https://leetcode.com/problems/dot-product-of-two-sparse-vectors

# Given two sparse vectors, compute their dot product.

# Implement class SparseVector:

# SparseVector(nums) Initializes the object with the vector nums
# dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
# A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

# Follow up: What if only one of the vectors is sparse?

# Example 1:
# Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
# Output: 8
# Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
# v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

# Example 2:
# Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
# Output: 0
# Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
# v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

# Example 3:
# Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
# Output: 6
 
# Constraints:
# n == nums1.length == nums2.length
# 1 <= n <= 10^5
# 0 <= nums1[i], nums2[i] <= 100

# Let n be the length of the input array and L and L2 be the number of non-zero elements for the two vectors.
# Runtime complexity: O(n) for creating the <index, value> pair for non-zero values; O(L log(L2)) for calculating the dot product if L < L2.
# Space complexity: O(L) for creating the <index, value> pairs for non-zero values. O(1) for calculating the dot product.

class SparseVector:
    def __init__(self, nums: List[int]):
        self.pairs = [(i, num) for i, num in enumerate(nums) if num != 0]

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        result = 0

        if len(self.pairs) < len(vec.pairs):
            small = self.pairs
            large = vec.pairs
        else:
            small = vec.pairs
            large = self.pairs
        
        for i, num in small:
            val = self.binary_search(i, large)
            result += num * val if val != float('inf') else 0

        return result

    def binary_search(self, target: int, pair_list: list) -> int:
        left, right = 0, len(pair_list) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if pair_list[mid][0] == target:
                return pair_list[mid][1]
            elif pair_list[mid][0] < target:
                left = mid + 1
            else:
                right = mid - 1
        return float('inf')

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)
