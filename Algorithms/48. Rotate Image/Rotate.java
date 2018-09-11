//Author: Tushar Jaiswal
//Creation Date: 09/10/2018

/*You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note: You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++)
        {
            for(int j = 0; j < n - 1 - 2 * i; j++)
            {
                rotatePoints(matrix, new int[]{i, i + j}, new int[]{i + j, n - 1 - i}, new int[]{n - 1 - i, n - 1 - i - j}, new int[]{n - 1 - i - j, i});
            }
        }
    }
    
    public void rotatePoints(int[][] matrix, int[] a, int[] b, int[] c, int[] d)
    {
        int temp = matrix[a[0]][a[1]];
        matrix[a[0]][a[1]] = matrix[d[0]][d[1]];
        matrix[d[0]][d[1]] = matrix[c[0]][c[1]];
        matrix[c[0]][c[1]] = matrix[b[0]][b[1]];
        matrix[b[0]][b[1]] = temp;
    }
}