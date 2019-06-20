//Author: Tushar Jaiswal
//Creation Date: 06/20/2019

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/

public class Solution {
    public int Trap(int[] height) {
        int totalWater = 0;
        int size = height.Length;
        for(int i = 1; i < size - 1; i++)
        {
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--)
            {
                maxLeft = Math.Max(maxLeft, height[j]);
            }
            for(int j = i; j < size; j++)
            {
                maxRight = Math.Max(maxRight, height[j]);
            }
            totalWater += Math.Min(maxLeft, maxRight) - height[i];
        }
        return totalWater;
    }
}
