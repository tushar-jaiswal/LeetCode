# Author: Tushar Jaiswal
# Creation Date: 2025-08-02

# Problem Source: https://leetcode.com/problems/merge-intervals

# Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

# Example 1:
# Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
# Output: [[1,6],[8,10],[15,18]]
# Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

# Example 2:
# Input: intervals = [[1,4],[4,5]]
# Output: [[1,5]]
# Explanation: Intervals [1,4] and [4,5] are considered overlapping. 

# Constraints:
# 1 <= intervals.length <= 10^4
# intervals[i].length == 2
# 0 <= starti <= endi <= 10^4

# Runtime Complexity: O(n log(n))
# Space Complexity: O(logN) (or O(n))
# Output is not counted in the space complexity.
# If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(logn) space. 
# Otherwise, we must allocate linear space to store a copy of intervals and sort that.

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals = sorted(intervals, key = lambda x:x[0])

        curr = intervals[0]
        result.append(curr)
        for i in range(1, len(intervals)):
            next = intervals[i]
            if(curr[1] >= next[0]):
                curr = [curr[0], max(curr[1], next[1])]
                result[-1] = curr
            else:
                curr = next
                result.append(curr)

        return result
