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
# Space Complexity: O(number of ints in string)

class Solution:
    def calculate(self, s: str) -> int:
        stack = Deque()

        i = 0
        while i < len(s):
            if s[i] == '+' or s[i] == ' ':
                i += 1
                continue
            elif s[i] == '/':
                val1 = stack.pop()
                sign1 = 1
                if val1 < 0:
                    sign1 = -1
                    val1 = -1 * val1
                val2, i, sign2 = self.get_val(s, i + 1)
                # Multiply sign separately else // will round down i.e. -3//2= -2
                print(val1, sign1, val2, sign2)
                floor_val = val1 // val2
                stack.append(sign1 * sign2 * floor_val)
            elif s[i] == '*':
                val1 = stack.pop()
                val2, i, sign = self.get_val(s, i + 1)
                stack.append(sign * val1 * val2)
            else: # int
                val, i, sign = self.get_val(s, i)
                stack.append(sign * val)
        
        result = 0
        for num in stack:
            result += num
            
        return result

    def get_val(self, s: str, i: int) -> (int, int):
        while i < len(s) and s[i] == ' ': # handle space after / and * 
            i += 1
        
        sign = 1
        if s[i] == '-':
            sign = -1
            i += 1

        num = ""
        while i < len(s) and 48 <= ord(s[i]) <= 57:
            num += s[i]
            i += 1
        return (int(num), i, sign)
