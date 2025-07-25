# Author: Tushar Jaiswal
# Creation Date: 2025-07-24

# Problem Source: https://leetcode.com/problems/encode-and-decode-strings/

# Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

# Machine 1 (sender) has the function:
# string encode(vector<string> strs) {
#   // ... your code
#   return encoded_string;
# }

# Machine 2 (receiver) has the function:
# vector<string> decode(string s) {
#   //... your code
#   return strs;
# }

# So Machine 1 does: string encoded_string = encode(strs);
# and Machine 2 does: vector<string> strs2 = decode(encoded_string);
# strs2 in Machine 2 should be the same as strs in Machine 1.
# Implement the encode and decode methods.
# You are not allowed to solve the problem using any serialize methods (such as eval).

# Example 1:
# Input: dummy_input = ["Hello","World"]
# Output: ["Hello","World"]
# Explanation:
# Machine 1:
# Codec encoder = new Codec();
# String msg = encoder.encode(strs);
# Machine 1 ---msg---> Machine 2
# Machine 2:
# Codec decoder = new Codec();
# String[] strs = decoder.decode(msg);

# Example 2:
# Input: dummy_input = [""]
# Output: [""]

# Constraints:
#     1 <= strs.length <= 200
#     0 <= strs[i].length <= 200
#     strs[i] contains any possible characters out of 256 valid ASCII characters.

# Follow up: Could you write a generalized algorithm to work on any possible set of characters?

# Runtime Complexity: O(n) where n is the total number of characters in all words.
#  * We are iterating through each string once.
# Space Complexity: O(k) where k is the number of words
#  * We don't count the output as part of the space complexity, but for each word, we are using some space for the escape character and delimiter.

class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        encoding = ""
        for s in strs:
            encoding += str(len(s)) + "." + s
        return encoding
        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        result = []
        i = 0
        while i < len(s):
            delimiter_index = s.find(".", i)
            word_length = int(s[i:delimiter_index])
            i = delimiter_index + 1 + word_length
            current_string = s[delimiter_index + 1:i]
            result.append(current_string)

        return result
