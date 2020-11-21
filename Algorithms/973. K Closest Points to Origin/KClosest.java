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

/*Runtime Complexity: O(number of points * log(K))
Space Complexity: O(log(K))*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        var priorityQueue = new PriorityQueue<Point>();

        for (int[] point : points) {
            priorityQueue.add(new Point(point));
            if (priorityQueue.size() > K) {
                priorityQueue.remove();
            }
        }

        int i = 0;
        while (priorityQueue.size() != 0) {
            result[i++] = priorityQueue.remove().coordinates;
        }
        return result;
    }
}

class Point implements Comparable<Point> {
    int[] coordinates;
    Double originDist;

    public Point(int[] coordinates) {
        this.coordinates = coordinates;
        originDist = getDistanceFromOrigin(coordinates);
    }

    private double getDistanceFromOrigin(int[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Point must have 2D cartesian coordinates.");
        }
        int x = coordinates[0];
        int y = coordinates[1];

        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point p) {
        return p.originDist.compareTo(this.originDist);
    }
}
