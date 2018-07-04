//Author: Tushar Jaiswal
//Creation Date: 07/03/2018

/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
Note: Your returned answers (both index1 and index2) are not zero-based. You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++)
        {
            int target2 = target - numbers[i];
            int low = i + 1, high = numbers.length - 1;
            while(low <= high)
            {
                int mid = low + (high - low) / 2;
                if(numbers[mid] == target2)
                { return new int[]{i + 1, mid + 1}; }
                else if(target2 < numbers[mid])
                { high = mid - 1; }
                else
                { low = mid + 1; }
            }
        }
        return new int[]{ -1, -1};
    }
}