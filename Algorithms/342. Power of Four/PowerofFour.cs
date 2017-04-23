//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
Example: Given num = 16, return true. Given num = 5, return false.
Follow up: Could you solve it without loops/recursion?*/

public class Solution {
    public bool IsPowerOfFour(int num) {
        return num > 0 && ((num & num-1) == 0) && (Convert.ToString(num, 2).Length % 2 != 0);
    }
}