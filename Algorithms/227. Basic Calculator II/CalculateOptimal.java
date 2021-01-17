//Author: Tushar Jaiswal
//Creation Date: 01/17/2021

/*Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
    1 <= s.length <= 3 * 105
    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    s represents a valid expression.
    All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    The answer is guaranteed to fit in a 32-bit integer.
*/

//Good test case: "-3 + 2 * 4 "

/*Runtime Complexity: O(length of string)
Space Complexity: O(1)*/

class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");

        char sign = '+';
        int result = 0;
        int prevNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            int currNumber = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                currNumber = currNumber * 10 + s.charAt(i) - '0';
                i++;
            }
            switch (sign) {
                case '+': result += prevNumber;
                    prevNumber = currNumber;
                    break;
                case '-': result += prevNumber;
                    prevNumber = -currNumber;
                    break;
                case '*': prevNumber *= currNumber;
                    break;
                case '/': prevNumber /= currNumber;
                    break;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
            }
        }

        result += prevNumber;
        return result;
    }
}
