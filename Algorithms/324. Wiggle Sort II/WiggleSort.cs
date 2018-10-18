//Author: Tushar Jaiswal
//Creation Date: 10/18/2018

/*Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:
Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:You may assume all input has valid answer.
Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?*/

public class Solution {
    public void WiggleSort(int[] nums) {
        SortedList<int, int> heap = new SortedList<int, int>(new DuplicateComparer<int>());
        foreach(int num in nums)
        {
            heap.Add(num, 0);
        }
        for(int i = 1; i < nums.Length; i+=2)
        {
            nums[i] = heap.Keys[0];
            heap.RemoveAt(0);
        }
        for(int i = 0; i < nums.Length; i+=2)
        {
            nums[i] = heap.Keys[0];
            heap.RemoveAt(0);
        }
    }
}

public class DuplicateComparer<TKey> : IComparer<TKey> where TKey : IComparable
{
    public int Compare(TKey a, TKey b)
    {
        int result = b.CompareTo(a);
        return result == 0 ? 1 : result;
    }
}