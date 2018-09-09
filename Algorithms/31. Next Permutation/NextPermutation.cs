//Author: Tushar Jaiswal
//Creation Date: 09/09/2018

/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/

public class Solution {
    public void NextPermutation(int[] nums) {
        int i = nums.Length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; i--);
        for(int j = nums.Length - 1; j > i && i >= 0; j--)
        {
            if(nums[j] > nums[i])
            { 
                Swap(ref nums[j], ref nums[i]); 
                break;
            }
        }
        Reverse(nums, i + 1);
    }
    
    public void Swap(ref int a, ref int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    
    public void Reverse(int[] nums, int left)
    {
        for(int right = nums.Length - 1; right > left; right--, left++)
        {
            Swap(ref nums[right], ref nums[left]);
        }
    }
}