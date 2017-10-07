//Author: Tushar Jaiswal
//Creation Date: 10/04/2017

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input: [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
        int numBoomerangs = 0;
        
        for(int i = 0; i < points.length; i++)
        {
            for(int j = 0; j < points.length; j++)
            {
                if (i == j)
                { continue; }
                int distance = calculateDistance(points[i], points[j]);
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            
            for(int count : distances.values())
            {
                numBoomerangs += count * (count - 1);
            }
            distances.clear();
        }
        
        return numBoomerangs;
    }
    
    private int calculateDistance(int[] p1, int[] p2)
    {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return dx * dx + dy * dy;
    }
}