//Author: Tushar Jaiswal
//Creation Date: 01/16/2021

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:
    0 <= n, m <= 200
    1 <= n + m <= 200
    nums1.length == m + n
    nums2.length == n
    -10^9 <= nums1[i], nums2[i] <= 10^9
*/

/*Runtime Complexity: O(m + n)
Space Complexity: O(1)*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Two pointers pointing to the end of two arrays
        int p1 = m - 1;
        int p2 = n - 1;

        // Pointer for the merged array nums1, pointing to its end
        int p = m + n - 1;

        // While there are elements left in both arrays to compare
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        // If p1 > 0 here, its elements are already in nums1 at the beginning.
        // If p2 > 0 here, let's add its elements from nums2 to nums1
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}
