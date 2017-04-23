//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
Example: Given num = 16, return true. Given num = 5, return false.
Follow up: Could you solve it without loops/recursion?*/

public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("^10*$");
    }
}