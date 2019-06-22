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

public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
        { throw new ArgumentNullException("Input argument can't be null"); }
        int len1 = nums1.Length;
        int len2 = nums2.Length;
        if(len1 > len2)
        {
            Swap(ref nums1, ref nums2);
            Swap(ref len1, ref len2);
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
                                         : Math.Max(nums1[count1 - 1], nums2[count2 - 1]);

                if((len1 + len2) % 2 == 1)
                { return leftItem; }
                else
                {
                    int rightItem = (count1 == len1)
                                   ? nums2[count2]
                                   : (count2 == len2)
                                         ? nums1[count1]
                                         : Math.Min(nums1[count1], nums2[count2]);
                    return (leftItem + rightItem) / 2.0;
                }
            }
        }
        throw new InvalidOperationException("Unhandled code segment");
    }

    public void Swap<T>(ref T a, ref T b)
    {
        T temp = a;
        a = b;
        b = temp;
    }
}
