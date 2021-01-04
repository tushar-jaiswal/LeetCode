//Author: Tushar Jaiswal
//Creation Date: 01/04/2021

/*Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

Example 1:
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

Example 2:
Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.

Constraints:
    0 <= pushed.length == popped.length <= 1000
    0 <= pushed[i], popped[i] < 1000
    pushed is a permutation of popped.
    pushed and popped have distinct values.
*/

/*Runtime Complexity: O(n) where n is the length of pushed and popped arrays
Space Complexity: O(1)*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        int stackPos = 0;
        int poppedPos = 0;

        for (int num : pushed) {
            pushed[stackPos] = num;
            stackPos++;
            while (stackPos > 0 && pushed[stackPos - 1] == popped[poppedPos]) {
                stackPos--;
                poppedPos++;
            }
        }
        return poppedPos == popped.length;
    }
}
/*
pushed = 1,2,3,4,5,6,4
popped = 4,6,5,4,3,2,1

pushed = 1,2,3,4,5,6,4,3
popped = 3,4,6,5,4,3,2,1
*/
