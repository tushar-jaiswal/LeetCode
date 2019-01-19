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
 * public class Point {
 *     public int x;
 *     public int y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int MaxPoints(Point[] points) {
        if(points.Length <= 2)
        { return points.Length; }
        int maxPoints = 1;
        for(int i = 0; i < points.Length && points.Length - i > maxPoints; i++)
        {
            Dictionary<Tuple<int, int>, int> dict = new Dictionary<Tuple<int, int>, int>();
            int currMax = 0, repeatPoints = 0;
            for(int j = i + 1; j < points.Length; j++)
            {
                int x = points[i].y - points[j].y;
                int y = points[i].x - points[j].x;
                if(x == 0 && y == 0)
                {
                    repeatPoints++;
                    continue;
                }
                int gcd = x < y ? GetGCD(x, y) : GetGCD(y, x);
                x /= gcd;
                y /= gcd;
                if(x > 0 && y < 0)
                {
                    x = -x;
                    y = -y;
                }
                Tuple<int, int> slope = new Tuple<int, int>(x, y);
                if(!dict.ContainsKey(slope))
                {
                    dict[slope] = 1;
                }
                else
                {
                    dict[slope]++;
                }
                currMax = Math.Max(currMax, dict[slope]);
            }
            maxPoints = Math.Max(maxPoints, currMax + repeatPoints + 1);
        }
        return maxPoints;
    }

    public int GetGCD(int a, int b)
    {
        if(a == 0)
        { return b; }
        return GetGCD(b % a, a);
    }
}
