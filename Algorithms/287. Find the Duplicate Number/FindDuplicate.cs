//Author: Tushar Jaiswal
//Creation Date: 07/04/2018

/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/

public class Solution {
    public int FindDuplicate(int[] nums) {
        int low = 1, high = nums.Length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int count = 0;
            foreach(int i in nums)
            {
                if(i <= mid)
                { count++; }
            }
            if(count > mid)
            { high = mid - 1; }
            else
            { low = mid + 1; }
        }
        return low;
    }
}