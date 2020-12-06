//Author: Tushar Jaiswal
//Creation Date: 12/05/2020

/* Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note: The string will only contain lowercase characters a-z. The maximum length of the string is 50000.*/

/*Runtime Complexity: O(n).
Space Complexity: O(1)*/

class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                boolean successOnDeleteLeft = true;
                boolean successOnDeleteRight = true;
                for (int k = i + 1, l = j; k < l; k++, l--) {
                    if(s.charAt(k) != s.charAt(l)) {
                        successOnDeleteLeft = false;
                        break;
                    }
                }
                for (int k = i, l = j - 1; k < l; k++, l--) {
                    if(s.charAt(k) != s.charAt(l)) {
                        successOnDeleteRight = false;
                        break;
                    }
                }
                return successOnDeleteLeft || successOnDeleteRight ? true : false;
            }
        }
        return true;
    }
}
