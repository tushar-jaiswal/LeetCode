//Author: Tushar Jaiswal
//Creation Date: 10/28/2018

/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:
Input: [1,2,3,4,5]
Output: true

Example 2:
Input: [5,4,3,2,1]
Output: false*/

public class Solution {
    public bool IncreasingTriplet(int[] nums) {
        if(nums.Length < 3)
        { return false; }
        int minA = nums[0];
        int minB = Int32.MaxValue;
        for(int i = 1; i < nums.Length; i++)
        {
            if(nums[i] < minA)
            {
                minA = nums[i];
            }
            else if(nums[i] > minA && nums[i] < minB)
            {
                minB = nums[i];
            }
            else if(nums[i] > minB)
            {
                return true;
            }
        }
        return false;
    }
}