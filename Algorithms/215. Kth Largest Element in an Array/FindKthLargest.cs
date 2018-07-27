//Author: Tushar Jaiswal
//Creation Date: 07/27/2018

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: You may assume k is always valid, 1 = k = array's length.*/

public class Solution {
    public int FindKthLargest(int[] nums, int k) {
        int low = 0, high = nums.Length - 1;
        
        while(low <= high)
        {
            Random rnd = new Random();
            int pivot = rnd.Next(low, high + 1);
            Swap(ref nums[pivot], ref nums[high]);
            
            int i = low - 1;
            for(int j = low; j < high; j++)
            {
                if(nums[j] <= nums[high])
                {
                    i++;
                    Swap(ref nums[i], ref nums[j]);
                }
            }
            Swap(ref nums[i + 1], ref nums[high]);
            if(nums.Length - k == i + 1)
            { return nums[i + 1]; }
            if(nums.Length - k < i + 1)
            { high = i; }
            else
            { low = i + 2; }
        }
        return -1;
    }
    
    private void Swap(ref int a, ref int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
}