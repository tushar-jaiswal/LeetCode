//Author: Tushar Jaiswal
//Creation Date: 06/18/2018
    
/*Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]

Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104*/

public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        List<int> result = new List<int>();
        
        int start = 0, end = arr.Length - 1, mid = -1;
        while(start <= end)
        {
            mid = start + (end - start) / 2;
            if(arr[mid] == x)
            { break; }
            else if(arr[mid] > x)
            { end = mid - 1; }
            else
            { start = mid + 1; }
        }
        if(arr[mid] != x)
        {
            if(mid - 1 >= 0 && x - arr[mid - 1] < arr[mid] - x)
            { mid -= 1; }
            else if(mid + 1 < arr.Length && arr[mid + 1] - x < arr[mid] - x)
            { mid += 1; }
        }
        
        int i, left, right;
        for(i = 1, left = mid - 1, right = mid + 1; i < k; i++)
        {
            if(left >= 0 && right < arr.Length)
            {
                if((x - arr[left]) <= (arr[right] - x))
                { left--; }
                else
                { right++; }
            }
            else
            {
                if(left < 0)
                {
                    break;
                }
                if(right >= arr.Length)
                {
                    left -= k - i;
                    break;
                }
            }
        }
        left++;
        
        for(i = 0; i < k; i++)
        {
            result.Add(arr[left + i]);
        }
        
        return result;
    }
}