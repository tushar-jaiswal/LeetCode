//Author: Tushar Jaiswal
//Creation Date: 05/26/2017

/*Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
Example: Given a = 1 and b = 2, return 3.*/

public class Solution {
    public int GetSum(int a, int b) {
        return (b == 0) ? a : GetSum(a^b, (a&b) << 1);
    }
}