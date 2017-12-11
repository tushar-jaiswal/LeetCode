//Author: Tushar Jaiswal
//Creation Date: 12/11/2017

/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:
Input: [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/

public class Solution {
    public int MinMoves(int[] nums) {
        if(nums.Length == 0)
        { return 0; }
        
        int minIndex = 0;
        int moves = 0;
        for(int i = 1; i < nums.Length; i++)
        {
            if(nums[i] < nums[minIndex])
            { minIndex = i; }
        }
        
        for(int i = 0; i < nums.Length; i++)
        {
            if(i != minIndex)
            {
                moves += nums[i] - nums[minIndex];
            }
        }
        
        return moves;
    }
}