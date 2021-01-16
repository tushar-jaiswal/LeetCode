//Author: Tushar Jaiswal
//Creation Date: 14/01/2021

/*Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []

Constraints:
    0 <= num.length <= 10
    num only contain digits.*/

/*Runtime Complexity: O(n*4^(n - 1)) where n is the length of num
Space Complexity: O(length of num) because of the depth of the recursion stack. The result is also of the same size.*/

class Solution {
    public List<String> addOperators(String num, int target) {
        var result = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return result;
        }
        getStringsToTarget(num.toCharArray(), 0, target, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void getStringsToTarget(char[] num, int pos, int target, long lastOperand, long value, StringBuilder curr, List<String> result) {
        if (pos == num.length) {
            if (value == target) {
                result.add(curr.toString());
            }
            return;
        }

        long operand = 0;
        for (int i = pos; i < num.length; i++) {
            if (num[pos] == '0' && i > pos) {
                break;
            }
            operand = operand * 10 + num[i] - '0';
            int len = curr.length();

            if (pos == 0) {
                getStringsToTarget(num, i + 1, target, operand, operand, curr.append(operand), result);
                curr.setLength(len);
            } else {
                getStringsToTarget(num, i + 1, target, operand, value + operand, curr.append("+").append(operand), result);
                curr.setLength(len);

                getStringsToTarget(num, i + 1, target, -operand, value - operand, curr.append("-").append(operand), result);
                curr.setLength(len);

                getStringsToTarget(num, i + 1, target, lastOperand * operand, value - lastOperand + lastOperand * operand, curr.append("*").append(operand), result);
                curr.setLength(len);
            }

        }
    }
}
