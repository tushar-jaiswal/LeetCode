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

public class Solution {
    public void Rotate(int[,] matrix) {
        int n = matrix.GetLength(0);
        for(int i = 0; i < n / 2; i++)
        {
            for(int j = 0; j < n - 1 - 2 * i; j++)
            {
                RotatePoints(ref matrix[i, i + j], ref matrix[i + j, n - 1 - i], ref matrix[n - 1 - i, n - 1 - i - j], ref matrix[n - 1 - i -j, i]);
            }
        }
    }
    
    public void RotatePoints(ref int a, ref int b, ref int c, ref int d)
    {
        int temp = a;
        a = d;
        d = c;
        c = b;
        b = temp;
    }
}