# Author: Tushar Jaiswal
# Creation Date: 2025-08-04

# Problem Source: https://leetcode.com/problems/basic-calculator-ii/

# Given a string s which represents an expression, evaluate this expression and return its value. 
# The integer division should truncate toward zero.
# You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
# Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

# Example 1:
# Input: s = "3+2*2"
# Output: 7

# Example 2:
# Input: s = " 3/2 "
# Output: 1

# Example 3:
# Input: s = " 3+5 / 2 "
# Output: 5

# Constraints:
# 1 <= s.length <= 3 * 10^5
# s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
# s represents a valid expression.
# All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
# The answer is guaranteed to fit in a 32-bit integer.

# Runtime Complexity: O(n) where n is length of the string
# Space Complexity: O(1)

class Solution:
    def calculate(self, s: str) -> int:
        s =s.replace(" ", "")
        i, sign, prev, result = 0, "+", 0, 0

        while i < len(s):
            curr = 0
            while i < len(s) and s[i].isdigit():
                curr = curr * 10 + int(s[i])
                i += 1
            if sign == "+":
                result += prev
                prev = curr
            elif sign == "-":
                result += prev
                prev = -curr
            elif sign == "*":
                prev = prev * curr
            elif sign == "/":
                prev = int(prev / curr)
            if i < len(s):
                sign = s[i]
            i += 1
        
        result += prev
        return result
                
