# Author: Tushar Jaiswal
# Creation Date: 2025-08-06

# Problem Source: https://leetcode.com/problems/minimum-window-substring

# Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

# The testcases will be generated such that the answer is unique.

# Example 1:
# Input: s = "ADOBECODEBANC", t = "ABC"
# Output: "BANC"
# Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

# Example 2:
# Input: s = "a", t = "a"
# Output: "a"
# Explanation: The entire string s is the minimum window.

# Example 3:
# Input: s = "a", t = "aa"
# Output: ""
# Explanation: Both 'a's from t must be included in the window.
# Since the largest window of s only has one 'a', return empty string.

# Constraints:
# m == s.length
# n == t.length
# 1 <= m, n <= 10^5
# s and t consist of uppercase and lowercase English letters.

# Follow up: Could you find an algorithm that runs in O(m + n) time?

# Runtime complexity: O(m)
# Space complexity: O(n)

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        freq_map = Counter(t)
        counter = len(freq_map)
        begin = end = 0
        length = float('inf')

        while end < len(s):
            c = s[end]
            end += 1

            if c in freq_map:
                freq_map[c] -=1
                if freq_map[c] == 0:
                    counter -= 1

            while counter == 0:
                temp_c = s[begin]
                if temp_c in freq_map:
                    if freq_map[temp_c] == 0:
                        counter += 1
                    freq_map[temp_c] += 1

                new_length = end - begin
                if new_length < length:
                    length = new_length
                    head = begin
                begin += 1

        return "" if length == float('inf') else s[head:head + length]
