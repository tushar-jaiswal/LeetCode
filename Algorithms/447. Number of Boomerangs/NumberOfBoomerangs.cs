//Author: Tushar Jaiswal
//Creation Date: 10/04/2017

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input: [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/

public class Solution {
    public int NumberOfBoomerangs(int[,] points) {
        Dictionary<int, int> distances = new Dictionary<int, int>();
        int numBoomerangs = 0;
        
        for(int i = 0; i < points.GetLength(0); i++)
        {
            for(int j = 0; j < points.GetLength(0); j++)
            {
                if (i == j)
                { continue; }
                int distance = calculateDistance(points[i, 0], points[i, 1], points[j, 0], points[j, 1]);
                
                if(distances.ContainsKey(distance))
                {
                    distances[distance] = distances[distance] + 1;
                }
                else
                {
                    distances.Add(distance, 1);
                }
            }   
            
            foreach(int count in distances.Values)
            {
                numBoomerangs += count * (count - 1);
            }
            distances.Clear();
        }
        
        return numBoomerangs;
    }
    
    private int calculateDistance(int x1, int y1, int x2, int y2)
    {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return dx * dx + dy * dy;
    }
}