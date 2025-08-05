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

# Let n be the length of the input array and L be the number of non-zero elements.
# Runtime complexity: O(n) for creating the Hash Map; O(L) for calculating the dot product.
# Space complexity: O(L) for creating the Hash Map, as we only store elements that are non-zero. O(1) for calculating the dot product.

class SparseVector:
    def __init__(self, nums: List[int]):
        self.index_val_map = {}
        for i in range(len(nums)):
            if nums[i] != 0:
                self.index_val_map[i] = nums[i]

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        result = 0
        if len(self.index_val_map) < len(vec.index_val_map):
            small = self.index_val_map
            large = vec.index_val_map
        else:
            small = vec.index_val_map
            large = self.index_val_map
        for key in small.keys():
            if key in large.keys():
                result += small[key] * large[key]
        return result

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)
