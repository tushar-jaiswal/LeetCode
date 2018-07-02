//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Given two arrays, write a function to compute their intersection.
Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note: Each element in the result must be unique. The result can be in any order.*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
        { return intersectionHelper(nums1, nums2); }
        else
        { return intersectionHelper(nums2, nums1); }
    }
    
    private int[] intersectionHelper(int[] smallNums, int[] largeNums)
    {
        HashSet<Integer> intersection = new HashSet<Integer>();
        Arrays.sort(smallNums);
        
        for(int i: largeNums)
        {
            if(binarySearch(i, smallNums))
            { intersection.add(i); }
        }
        
        int[] result = new int[intersection.size()];
        int index = 0;
        for(Integer i : intersection)
        {
            result[index++] = i.intValue();
        }
        return result;
    }
    
    private boolean binarySearch(int target, int[] nums)
    {
        int low = 0, high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
            { return true; }
            if(target < nums[mid])
            { high = mid - 1; }
            else
            { low = mid + 1; }
        }
        return false;
    }
}