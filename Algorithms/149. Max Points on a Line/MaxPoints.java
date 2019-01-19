//Author: Tushar Jaiswal
//Creation Date: 01/19/2019

/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 2)
        { return points.length; }
        int maxPoints = 1;
        for(int i = 0; i < points.length && points.length - i > maxPoints; i++)
        {
            HashMap<Map.Entry<Integer, Integer>, Integer> map = new HashMap<Map.Entry<Integer, Integer>, Integer>();
            int currMax = 0, repeatPoints = 0;
            for(int j = i + 1; j < points.length; j++)
            {
                int x = points[i].y - points[j].y;
                int y = points[i].x - points[j].x;
                if(x == 0 && y == 0)
                {
                    repeatPoints++;
                    continue;
                }
                int gcd = x < y ? getGCD(x, y) : getGCD(y, x);
                x /= gcd;
                y /= gcd;
                if(x > 0 && y < 0)
                {
                    x = -x;
                    y = -y;
                }
                Map.Entry<Integer, Integer> slope = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(x, y);
                if(!map.containsKey(slope))
                {
                    map.put(slope, 1);
                }
                else
                {
                    map.put(slope, map.get(slope) + 1);
                }
                currMax = Math.max(currMax, map.get(slope));
            }
            maxPoints = Math.max(maxPoints, currMax + repeatPoints + 1);
        }
        return maxPoints;
    }

    public int getGCD(int a, int b)
    {
        if(a == 0)
        { return b; }
        return getGCD(b % a, a);
    }
}
