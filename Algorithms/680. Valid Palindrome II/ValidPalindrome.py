# Author: Tushar Jaiswal
# Creation Date: 2025-08-01

# Problem Source: https://leetcode.com/problems/valid-palindrome-ii

# Given a string s, return true if the s can be palindrome after deleting at most one character from it.

# Example 1:
# Input: s = "aba"
# Output: true

# Example 2:
# Input: s = "abca"
# Output: true
# Explanation: You could delete the character 'c'.

# Example 3:
# Input: s = "abc"
# Output: false

# Runtime Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def validPalindrome(self, s: str) -> bool:
        for i in range(len(s) // 2):
            j = len(s) - 1 - i 
            if s[i] != s[j]:
                # Try removing a character from beginning and end of current substrand see if either becomes a palindrome
                # If removal didn't make it a palindrome, mismatch prevents it from being palindrome so return false
                return self.isPalindrome(s[i + 1 :j + 1]) or self.isPalindrome(s[i:j])

        # Valid palindrome as didn't need to remove anything as all characters matched from beginning to end
        return True

    def isPalindrome(self, s: str) -> bool:
        for i in range(len(s) // 2):
            j = len(s) - 1 - i 
            if(s[i] != s[j]):
                return False
        return True
