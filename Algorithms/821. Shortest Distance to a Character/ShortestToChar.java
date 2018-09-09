//Author: Tushar Jaiswal
//Creation Date: 09/09/2018

/*Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 
Note:
S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] result = new int[len];
        for(int i = 0; i < len; i++)
        { result[i] = -1; }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < len; i++)
        {
            if(S.charAt(i) == C)
            {
                result[i] = 0; 
                queue.offer(i);
            }
        }
        while(!queue.isEmpty())
        {
            int i = queue.poll();
            if(i - 1 >= 0 && result[i - 1] == -1)
            {
                result[i - 1] = result[i] + 1;
                queue.offer(i - 1);
            }
            if(i + 1 < len && result[i + 1] == -1)
            {
                result[i + 1] = result[i] + 1;
                queue.offer(i + 1);
            }
        }
        return result;
    }
}