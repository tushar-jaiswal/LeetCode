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

public class Solution {
    public int[] ShortestToChar(string S, char C) {
        int len = S.Length;
        int[] result = new int[len];
        Queue<int> queue = new Queue<int>();
        for(int i = 0; i < len; i++)
        {
            if(S[i] == C)
            {
                result[i] = 0; 
                queue.Enqueue(i);
            }
			else
			{ result[i] = -1; }
        }
        while(queue.Count != 0)
        {
            int i = queue.Dequeue();
            if(i - 1 >= 0 && result[i - 1] == -1)
            {
                result[i - 1] = result[i] + 1;
                queue.Enqueue(i - 1);
            }
            if(i + 1 < len && result[i + 1] == -1)
            {
                result[i + 1] = result[i] + 1;
                queue.Enqueue(i + 1);
            }
        }
        return result;
    }
}