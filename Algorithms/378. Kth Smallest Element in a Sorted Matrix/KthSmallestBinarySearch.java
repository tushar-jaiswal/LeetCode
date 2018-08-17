//Author: Tushar Jaiswal
//Creation Date: 08/16/2018

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
Note: You may assume k is always valid, 1 = k = n2.*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int maxNum = low;
            int count = 0;
            for(int i = 0, j = n - 1; i < n; i++)
            {
                while(j >= 0 && matrix[i][j] > mid) 
                { j--; }
                if(j >= 0)
                { 
                    count += j + 1;
                    maxNum = Math.max(maxNum, matrix[i][j]); 
                }
            }
            if(count == k)
            { return maxNum; }
            if(count < k)
            { low = mid + 1; }
            else
            { high = mid - 1; }
        }
        return low;
    }
}