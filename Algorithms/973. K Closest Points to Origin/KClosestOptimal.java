//Author: Tushar Jaiswal
//Creation Date: 11/21/2020

/*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Note:
    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000*/

/*Runtime Complexity: O(number of points)
Space Complexity: O(K)*/

import java.util.concurrent.ThreadLocalRandom;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];

        quickSort(points, 0, points.length - 1, K);

        while (K != 0) {
            result[--K] = points[K];
        }

        return result;
    }

    private void quickSort(int[][] points, int low, int high, int K) {
        if (low <= high) {
            int partitionPoint = partition(points, low, high);
            if (partitionPoint == K) {
                return;
            } else if (partitionPoint < K) {
                low = partitionPoint + 1;
            } else {
                high = partitionPoint - 1;
            }
            quickSort(points, low, high, K);
        }
    }

    private int partition(int[][] points, int low, int high) {
        int pivot = ThreadLocalRandom.current().nextInt(low, high + 1);
        swap(points, pivot, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(points[j], points[high]) <= 0) {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, i + 1, high);
        return i + 1;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int compare(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
    }
}
