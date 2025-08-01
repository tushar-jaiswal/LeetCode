# Author: Tushar Jaiswal
# Creation Date: 2025-08-01

# Problem Source: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

# Given a string s of '(' , ')' and lowercase English characters.

# Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

# Formally, a parentheses string is valid if and only if:
#     It is the empty string, contains only lowercase characters, or
#     It can be written as AB (A concatenated with B), where A and B are valid strings, or
#     It can be written as (A), where A is a valid string.

# Example 1:
# Input: s = "lee(t(c)o)de)"
# Output: "lee(t(c)o)de"
# Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

# Example 2:
# Input: s = "a)b(c)d"
# Output: "ab(c)d"

# Example 3:
# Input: s = "))(("
# Output: ""
# Explanation: An empty string is also valid.

# Constraints:
#     1 <= s.length <= 105
#     s[i] is either '(' , ')', or lowercase English letter.

# Runtime Complexity: O(n) where n is the length of the input string
# Space Complexity: O(n)

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = deque()
        removal_indexes = set()

        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if len(stack) == 0:
                    removal_indexes.add(i)
                else:
                    stack.pop()
        
        removal_indexes = removal_indexes.union(set(stack))
        
        string_builder = []
        for i, c in enumerate(s):
            if i not in removal_indexes:
                string_builder.append(c)

        return "".join(string_builder)
