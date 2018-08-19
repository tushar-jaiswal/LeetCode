//Author: Tushar Jaiswal
//Creation Date: 08/19/2018

/*You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:
Input: [1,2,3,4,4,5]
Output: False

Note:The length of the input is in range of [1, 10000]*/

public class Solution {
    public bool IsPossible(int[] nums) {
        int freq, prev, p1 = 0, p2 = 0, p3 = 0, c1 = 0, c2 = 0, c3 = 0;
        prev = Int32.MinValue;
        
        for(int i = 0; i < nums.Length; i++, p1 = c1, p2 = c2, p3 = c3, prev = nums[i - 1])
        {
            for(freq = 1; i < nums.Length - 1 && nums[i + 1] == nums[i]; freq++, i++);
            
            if(prev + 1 != nums[i])
            {
                if(p1 != 0 || p2 != 0)
                { return false; }
                c1 = freq;
                c2 = 0;
                c3 = 0;
            }
            else
            {
                if(freq < p1 + p2)
                { return false; }
                c2 = p1;
                c3 = p2 + Math.Min(p3, freq - (p1 + p2));
                c1 = Math.Max(0, freq - (p1 + p2 + p3));
            }
        }
        return (p1 == 0 && p2 == 0);
    }
}