//Author: Tushar Jaiswal
//Creation Date: 06/20/2019

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
        { return 0; }
        int totalWater = 0;
        int size = height.length;
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];
        maxLeft[0] = height[0];
        maxRight[size - 1] = height[size - 1];
        for(int i = 1; i < size; i++)
        {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for(int i = size - 2; i >= 0; i--)
        {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for(int i = 1; i < size - 1; i++)
        {
            totalWater += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return totalWater;
    }
}
