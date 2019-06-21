//Author: Tushar Jaiswal
//Creation Date: 06/20/2019

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/

public class Solution {
    public int Trap(int[] height) {
        if(height == null)
        { return 0; }
        int totalWater = 0;
        int left = 0, right = height.Length - 1;
        int maxLeft = 0, maxRight = 0;
        while(left < right)
        {
            if(height[left] < height[right])
            {
                if(height[left] < maxLeft)
                { totalWater += maxLeft - height[left]; }
                else
                { maxLeft = height[left]; }
                left++;
            }
            else
            {
                if(height[right] < maxRight)
                { totalWater += maxRight - height[right]; }
                else
                { maxRight = height[right]; }
                right--;
            }
        }
        return totalWater;
    }
}
