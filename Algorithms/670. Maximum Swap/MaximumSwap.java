//Author: Tushar Jaiswal
//Creation Date: 01/16/2021

/* Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Note: The given number is in the range [0, 108] */

/*Runtime Complexity: O(length of num) or O(1) if we consider that int is 32 bits with at most 10 digits
Space Complexity: O(length of num) or O(1) if we consider that int is 32 bits with at most 10 digits*/

class Solution {
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();

        //Get the last position of each digit in numArray
        int[] digitLastPosition = new int[10];
        for (int i = 0; i < numArray.length; i++) {
            digitLastPosition[numArray[i] - '0'] = i;
        }

        for (int i = 0; i < numArray.length; i++) {
            for (int digit = 9; digit > numArray[i] - '0'; digit--) {
                if (digitLastPosition[digit] > i) {
                    char temp = numArray[i];
                    numArray[i] = numArray[digitLastPosition[digit]];
                    numArray[digitLastPosition[digit]] = temp;
                    return Integer.valueOf(new String(numArray));
                }
            }
        }

        return num;
    }
}
