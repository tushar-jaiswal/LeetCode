//Author: Tushar Jaiswal
//Creation Date: 01/02/2021

/*Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input:
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation:
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.

Note:
    All the strings in the input will only contain lowercase letters.
    The length of S will be in the range [1, 20000].
    The length of T will be in the range [1, 100].
*/

/*Runtime Complexity: O(|S|^2)
Explanation:
    Outer loop runs through the length of S.
    If subsequence length is
        |S| - code runs 1 time forward and 1 time backward covering |S| each time
        |S - 1| - code runs 2 times forward and 2 times backward covering |S - 1| each time
        |S - 2| - code runs 3 times forward and 3 times backward covering |S - 1| each time
        ...
        |S/2| - code runs |S/2| times forward and |S/2| times backward covering |S/2| each time

Space Complexity: O(1)*/

class Solution {
    public String minWindow(String S, String T) {
        int inputPointer = 0;
        int patternPointer = 0;
        int startPointer = 0; // Keeps track of the start pointer for the result
        int minLength = -1; // Keeps track of the minimum length of the result


        while (inputPointer < S.length()) {
            if (S.charAt(inputPointer) == T.charAt(patternPointer)) {
                // Move to the next character of the pattern
                patternPointer++;

                // Entire pattern matched
                if (patternPointer == T.length()) {
                    // Get the shortest subsequence by traversing back from the last character

                    patternPointer--; // Get the last character of the pattern
                    int endPointer = inputPointer; // Keep track of the pattern's last character's position in the input

                    // While we haven't encountered all the pattern characters
                    while (patternPointer != 0) {
                        patternPointer--; // Get the previous character of the pattern
                        inputPointer--; // Get the previous character of the input

                        // Find the previous pattern character in the subsequence
                        while (S.charAt(inputPointer) != T.charAt(patternPointer)) {
                            inputPointer--;
                        }
                    }

                    int subsequenceLength = endPointer - inputPointer + 1;
                    if (minLength == -1 || subsequenceLength < minLength) {
                        startPointer = inputPointer;
                        minLength = subsequenceLength;
                    }
                }
            }
            inputPointer++;
        }

        return minLength == -1 ? "" : S.substring(startPointer, startPointer + minLength);
    }
}
