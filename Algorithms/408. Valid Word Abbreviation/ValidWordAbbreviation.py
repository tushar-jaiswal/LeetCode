# Author: Tushar Jaiswal
# Creation Date: 2025-08-03

# Problem Source: https://leetcode.com/problems/valid-word-abbreviation

# A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

# For example, a string such as "substitution" could be abbreviated as (but not limited to):

# "s10n" ("s ubstitutio n")
# "sub4u4" ("sub stit u tion")
# "12" ("substitution")
# "su3i1u2on" ("su bst i t u ti on")
# "substitution" (no substrings replaced)
# The following are not valid abbreviations:

# "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
# "s010n" (has leading zeros)
# "s0ubstitution" (replaces an empty substring)
# Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

# A substring is a contiguous non-empty sequence of characters within a string.

# Example 1:
# Input: word = "internationalization", abbr = "i12iz4n"
# Output: true
# Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").

# Example 2:
# Input: word = "apple", abbr = "a2e"
# Output: false
# Explanation: The word "apple" cannot be abbreviated as "a2e".

# Constraints:
# 1 <= word.length <= 20
# word consists of only lowercase English letters.
# 1 <= abbr.length <= 10
# abbr consists of lowercase English letters and digits.
# All the integers in abbr will fit in a 32-bit integer.

class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i = j = 0
        while i < len(word) and j < len(abbr):
            if word[i] == abbr[j]:
                i += 1
                j += 1
                continue
            elif abbr[j] == "0":
                    return False
            elif abbr[j].isnumeric():
                start_pos = j
                while j < len(abbr) and 48 <= ord(abbr[j]) <= 57:
                    j += 1
                num = int(abbr[start_pos:j])
                i += num
            else: # Not a number and didn't match characters
                return False
        return i == len(word) and j == len(abbr)
