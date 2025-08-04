# Author: Tushar Jaiswal
# Creation Date: 2025-08-03

# Problem Source: https://leetcode.com/problems/merge-sorted-array

# You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

# Merge nums1 and nums2 into a single array sorted in non-decreasing order.

# The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

# Example 1:
# Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
# Output: [1,2,2,3,5,6]
# Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
# The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

# Example 2:
# Input: nums1 = [1], m = 1, nums2 = [], n = 0
# Output: [1]
# Explanation: The arrays we are merging are [1] and [].
# The result of the merge is [1].

# Example 3:
# Input: nums1 = [0], m = 0, nums2 = [1], n = 1
# Output: [1]
# Explanation: The arrays we are merging are [] and [1].
# The result of the merge is [1].
# Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 
# Constraints:
# nums1.length == m + n
# nums2.length == n
# 0 <= m, n <= 200
# 1 <= m + n <= 200
# -10^9 <= nums1[i], nums2[j] <= 10^9

# Runtime Complexity: O(n+m)
# Space Complexity: O(1)

# To prove it, we need to ensure that p never overwrites a value in nums1 that p1 hasn't yet read from nums1.
# Words of Advice: Terrified of proofs? Many software engineers are. Good proofs are simply a series of logical assertions, each building on the next. In this way, we can go from "obvious" statements, all the way to the one we want to prove. I recommend reading each statement one by one, ensuring that you understand each before moving to the next.
# We know that upon initialization, p is n steps ahead of p1 (in other words, p1 + n = p).
# We also know that during each of the p iterations this algorithm performs, p is always decremented by 1, and either p1 or p2 is decremented by 1.
# We can deduce that when p1 decremented, the gap between p and p1 stays the same, so there can't be an "overtake" in that case.
# We can also deduce that when p2 is decremented though, the gap between p and p1 shrinks by 1 as p moves, but not p1.
# And from that, we can deduce that the maximum number of times that p2 can be decremented is n. In other words, the gap between p and p1 can shrink by 1, at most n times.
# In conclusion, it's impossible for an overtake to occur, as they started n apart. And when p = p1, the gap has to have shrunk n times. This means that all of nums2 have been merged in, so there is nothing more to do.

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # exhange larger elements of nums1 with num2 and loop until nums2 is complete
        p1 = m - 1
        p2 = n - 1
        for p in range(m + n - 1, -1, -1):
            if p2 < 0:
                break
            if p1 >= 0 and nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
