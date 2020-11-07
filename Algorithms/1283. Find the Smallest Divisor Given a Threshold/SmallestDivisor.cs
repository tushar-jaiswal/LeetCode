//Author: Tushar Jaiswal
//Creation Date: 11/07/2020

/*Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

It is guaranteed that there will be an answer.

Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

Example 2:
Input: nums = [2,3,5,7,11], threshold = 11
Output: 3

Example 3:
Input: nums = [19], threshold = 5
Output: 4

Constraints:

    1 <= nums.length <= 5 * 10^4
    1 <= nums[i] <= 10^6
    nums.length <= threshold <= 10^6*/

/*Runtime Complexity: O(len(nums) * log(max(nums)))
Space Complexity: O(1)*/

public class Solution {
    public int SmallestDivisor(int[] nums, int threshold) {
        if (nums.Length == 0) {
            throw new ArgumentException("Input array must have some elements.");
        } else if (threshold < nums.Length) {
            throw new ArgumentOutOfRangeException("Threshold must be larger than or equal to the size of the input array.");
        }

        int min = 1;
        int max = GetMax(nums);

        int smallestDivisor = 0;

        while (min <= max) {
            int divisor = min + (max - min) / 2;
            int sum = ComputeSum(nums, divisor);

            if (sum > threshold) {
                min = divisor + 1;
            } else {
                max = divisor - 1;
                smallestDivisor = divisor;
            }
        }

        return smallestDivisor;
    }

    private int GetMax(int[] nums) {
        int max = nums[0];
        foreach (int num in nums) {
            max = num > max ? num : max;
        }
        return max;
    }

    private int ComputeSum(int[] nums, int divisor) {
        int sum = 0;
        foreach (int num in nums) {
            int quotient = num / divisor;
            sum += num % divisor == 0 ? quotient : quotient + 1;
        }
        return sum;
    }
}
