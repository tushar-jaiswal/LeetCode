//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Given an integer array nums, find the sum of the elements between indices i and j (i = j), inclusive.
Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
1. You may assume that the array does not change.
2. There are many calls to sumRange function.*/

public class NumArray {

    int[] sum;
    
    public NumArray(int[] nums) {
        if(nums.Length > 0)
        {
            sum = new int[nums.Length];
            sum[0] = nums[0];
            for(int i = 1; i < nums.Length; i++)
            { 
                sum[i] = sum[i-1] + nums[i]; 
            }
        }
    }
    
    public int SumRange(int i, int j) {
        return (i > 0) ? (sum[j] - sum[i-1]) : sum[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.SumRange(i,j);
 */