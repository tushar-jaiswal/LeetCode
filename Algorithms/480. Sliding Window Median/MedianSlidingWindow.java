//Author: Tushar Jaiswal
//Creation Date: 12/27/2020

/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
Examples:

[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6

Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
Answers within 10^-5 of the actual value will be accepted as correct.
*/

/*Runtime Complexity: O(nlog(k))
Space Complexity: O(log(k))*/

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("k must not be greater than size of the input array.");
        }
        if (nums.length == 0 || k == 0) {
            return new double[0];
        }

        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<Integer>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<Integer>(comparator);

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            removeElementOutsideWindow(left, right, i, k);
            addElementInSortedOrder(left, right, i);
            balance(left, right);

            if (i >= k - 1) {
                result[i - (k - 1)] = getMedian(left, right, nums);
            }
        }

        return result;
    }

    private void removeElementOutsideWindow(TreeSet<Integer> left, TreeSet<Integer> right, int pos, int k) {
        if (pos >= k) {
            if (!left.remove(pos - k)) {
                right.remove(pos - k);
            }
        }
    }

    private void addElementInSortedOrder(TreeSet<Integer> left, TreeSet<Integer> right, int index) {
        left.add(index);
        right.add(left.pollFirst());
    }

    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        if (left.size() < right.size()) {
            left.add(right.pollFirst());
        }
    }

    private double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums) {
        if (left.size() > right.size()) {
            return (double) nums[left.first()];
        } else {
            return ((double) nums[left.first()] + nums[right.first()]) / 2.0;
        }
    }
}
