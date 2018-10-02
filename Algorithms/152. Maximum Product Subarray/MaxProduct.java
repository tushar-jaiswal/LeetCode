//Author: Tushar Jaiswal
//Creation Date: 10/01/2018

/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
        { return 0; }
        int maxPre = nums[0], minPre = nums[0], max, min, maxProduct = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
            maxProduct = Math.max(max, maxProduct);
            maxPre = max;
            minPre = min;
        }
        return maxProduct;
    }
}