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
# Runtime complexity: O(n) for creating the <index, value> pair for non-zero values; O(L+L2) for calculating the dot product.
# Space complexity: O(L) for creating the <index, value> pairs for non-zero values. O(1) for calculating the dot product.

class SparseVector:
    def __init__(self, nums: List[int]):
        self.pairs = []
        for i, val in enumerate(nums):
            if val != 0:
                self.pairs.append((i, val))

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        result = 0
        p1 = p2 = 0

        while p1 < len(self.pairs) and p2 < len(vec.pairs):
            if self.pairs[p1][0] == vec.pairs[p2][0]:
                result += self.pairs[p1][1] * vec.pairs[p2][1]
                p1 += 1
                p2 += 1
            elif self.pairs[p1][0] < vec.pairs[p2][0]:
                p1 += 1
            else:
                p2 += 1

        return result

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)
