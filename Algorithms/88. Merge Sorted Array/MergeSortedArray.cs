//Author: Tushar Jaiswal
//Creation Date: 06/28/2016
/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.*/
public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0, k=0;
        int[] nums3 = new int[m+n];
        while(i < m && j < n)
        {
            if(nums1[i] < nums2[j])
            {
                nums3[k++] = nums1[i++];
            }
            else
            {
                nums3[k++] = nums2[j++];
            }
        }
        while(i < m)
        {
            nums3[k++] = nums1[i++];
        }
        while(j < n)
        {
            nums3[k++] = nums2[j++];
        }
        
        for(k = 0; k < m+n; k++)
        {
            nums1[k] = nums3[k];
        }
    }
}