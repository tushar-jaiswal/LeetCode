//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
        { return intersectionHelper(nums1, nums2); }
        else
        { return intersectionHelper(nums2, nums1); }
    }
    
    private int[] intersectionHelper(int[] smallNums, int[] largeNums)
    {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(smallNums);
        
        HashMap<Integer, Integer> countUnfoundNums = new HashMap<Integer, Integer>();
        for(Integer i: smallNums)
        {
            if(countUnfoundNums.containsKey(i))
            { countUnfoundNums.replace(i, countUnfoundNums.get(i) + 1); }
            else
            { countUnfoundNums.put(i, 1); }
        }
        
        for(int i: largeNums)
        {
            if(binarySearch(i, smallNums))
            { 
                if(countUnfoundNums.get(i) > 0)
                { 
                    list.add(i); 
                    countUnfoundNums.replace(i, countUnfoundNums.get(i) - 1);
                }
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for(Integer i : list)
        { result[index++] = i.intValue(); }
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