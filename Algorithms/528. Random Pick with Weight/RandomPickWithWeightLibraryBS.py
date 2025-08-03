# Author: Tushar Jaiswal
# Creation Date: 2025-08-01

# Problem Source: https://leetcode.com/problems/random-pick-with-weight/

# You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
# You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
# For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 
# Example 1:
# Input
# ["Solution","pickIndex"]
# [[[1]],[]]
# Output
# [null,0]
# Explanation
# Solution solution = new Solution([1]);
# solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.

# Example 2:
# Input
# ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
# [[[1,3]],[],[],[],[],[]]
# Output
# [null,1,1,1,1,0]
# Explanation
# Solution solution = new Solution([1, 3]);
# solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
# solution.pickIndex(); // return 1
# solution.pickIndex(); // return 1
# solution.pickIndex(); // return 1
# solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

# Since this is a randomization problem, multiple answers are allowed.
# All of the following outputs can be considered correct:
# [null,1,1,1,1,0]
# [null,1,1,1,1,1]
# [null,1,1,1,0,0]
# [null,1,1,1,0,1]
# [null,1,0,1,0,0]
# ......
# and so on.
 
# Constraints:
# 1 <= w.length <= 104
# 1 <= w[i] <= 105
# pickIndex will be called at most 104 times.

# Runtime Complexity: initialization is O(n) and pickIndex is O(log(n))
# Space Complexity: O(n)

from bisect import bisect_left
import random

class Solution:

    def __init__(self, w: List[int]):
        cumulative_sum = 0
        self.cumulative_weights = []
        for weight in w:
            cumulative_sum += weight
            self.cumulative_weights.append(cumulative_sum)


    def pickIndex(self) -> int:
        rand = random.randint(1, self.cumulative_weights[-1])
        left = bisect_left(self.cumulative_weights, rand)
        return left
        # [1, 3] rand:2, left=1, right = 1 -> needed 1
        # [1, 3] rand:3, left=1, right = 2 -> needed 1
        # [1, 3] rand:1, left=0, right = 1 -> needed 0

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
