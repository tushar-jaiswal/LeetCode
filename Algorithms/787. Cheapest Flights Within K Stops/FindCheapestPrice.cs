//Author: Tushar Jaiswal
//Creation Date: 08/22/2018

/*There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

Note:
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.*/

public class Solution {
    public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Dictionary<int, List<int[]>> graph = new Dictionary<int, List<int[]>>();
        SortedList<int, int[]> heap = new SortedList<int, int[]>(new DuplicateKeyComparer<int>());
        heap.Add(0, new int[]{src, 0});
        
        for(int i = 0; i < flights.GetLength(0); i++)
        {
            if(!graph.ContainsKey(flights[i][0]))
            { graph.Add(flights[i][0], new List<int[]>()); }
            graph[flights[i][0]].Add(new int[]{flights[i][1], flights[i][2]});
        }
        
        while(heap.Count != 0)
        {
            int cost = heap.Keys[0];
            int city = heap.Values[0][0];
            int stops = heap.Values[0][1];
            heap.RemoveAt(0);
            if(city == dst)
            { return cost; }
            if(graph.ContainsKey(city))
            {
                foreach(int[] edge in graph[city])
                {
                    if(stops + 1 <= K + 1)
                    { heap.Add(cost + edge[1], new int[]{edge[0], stops + 1}); }
                }
            }
        }
        return -1;
    }
}

public class DuplicateKeyComparer<TKey> : IComparer<TKey> where TKey : IComparable
{
    public int Compare(TKey a, TKey b)
    {
        int result = a.CompareTo(b);
        return result == 0 ? 1 : result;
    }
}