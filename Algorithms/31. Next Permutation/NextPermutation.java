//Author: Tushar Jaiswal
//Creation Date: 09/09/2018

/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; i--);
        for(int j = nums.length - 1; j > i && i >= 0; j--)
        {
            if(nums[j] > nums[i])
            { 
                swap(nums, j, i); 
                break;
            }
        }
        reverse(nums, i + 1);
    }
    
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(int[] nums, int left)
    {
        for(int right = nums.length - 1; right > left; right--, left++)
        {
            swap(nums, right, left);
        }
    }
}