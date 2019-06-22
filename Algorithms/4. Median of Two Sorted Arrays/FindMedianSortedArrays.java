//Author: Tushar Jaiswal
//Creation Date: 06/22/2019

/*There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
        { throw new NullPointerException("Input argument can't be null"); }
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2)
        {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int len = len1;
            len1 = len2;
            len2 = len;
        }

        int leftHalfLength = len1 + (len2 - len1 + 1) / 2;
        int minCount1 = 0;
        int maxCount1 = len1;
        while(minCount1 <= maxCount1)
        {
            int count1 = minCount1 + (maxCount1 - minCount1) / 2;
            int count2 = leftHalfLength - count1;

            if(count1 > 0 && nums1[count1 - 1] > nums2[count2])
            {
                maxCount1 = count1 - 1;
            }
            else if(count1 < len1 && nums2[count2 - 1] > nums1[count1])
            {
                minCount1 = count1 + 1;
            }
            else
            {
                int leftItem = (count1 == 0)
                                   ? nums2[count2 - 1]
                                   : (count2 == 0)
                                         ? nums1[count1 - 1]
                                         : Math.max(nums1[count1 - 1], nums2[count2 - 1]);

                if((len1 + len2) % 2 == 1)
                { return leftItem; }
                else
                {
                    int rightItem = (count1 == len1)
                                   ? nums2[count2]
                                   : (count2 == len2)
                                         ? nums1[count1]
                                         : Math.min(nums1[count1], nums2[count2]);
                    return (leftItem + rightItem) / 2.0;
                }
            }
        }
        throw new IllegalStateException("Unhandled code segment");
    }
}
