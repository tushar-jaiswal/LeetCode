# Author: Tushar Jaiswal
# Creation Date: 2025-08-11

# Problem Source: https://leetcode.com/problems/most-profit-assigning-work

# You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

# difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
# worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
# Every worker can be assigned at most one job, but one job can be completed multiple times.

# For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
# Return the maximum profit we can achieve after assigning the workers to the jobs.

# Example 1:
# Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
# Output: 100
# Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.

# Example 2:
# Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
# Output: 0

# Constraints:
# n == difficulty.length
# n == profit.length
# m == worker.length
# 1 <= n, m <= 10^4
# 1 <= difficulty[i], profit[i], worker[i] <= 10^5

# Let n be the size of the difficulty and profit arrays and m be the size of the worker array. Also, let maxAbility be the maximum value in the worker array.
# # Runtime complexity: O(n+m+maxAbility)
#   In this approach, we iterate through the difficulty, worker and jobs arrays exactly once.
#   Therefore, the total time complexity is given by O(n+m+maxAbility).
# Space complexity: O(maxAbility)
#   We create an additional jobs array of size maxAbility. Apart from this, no additional space is used.
#   Therefore, space complexity is given by O(maxAbility).

class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        max_worker_difficulty = max(worker)
        max_profit_for_difficulty = [0] * (max_worker_difficulty + 1) # +1 needed to access index of max_worker_difficulty

        # Get max profit for each difficulty in case there are multiple jobs of same difficulty but different profit
        for i in range(len(difficulty)):
            if difficulty[i] <= max_worker_difficulty:
                max_profit_for_difficulty[difficulty[i]] = max(max_profit_for_difficulty[difficulty[i]], profit[i])
        
        # Get max profit up to each difficulty
        for i in range(1, len(max_profit_for_difficulty)):
            max_profit_for_difficulty[i] = max(max_profit_for_difficulty[i], max_profit_for_difficulty[i - 1])

        profit = 0
        for ability in worker:
            profit += max_profit_for_difficulty[ability]

        return profit
