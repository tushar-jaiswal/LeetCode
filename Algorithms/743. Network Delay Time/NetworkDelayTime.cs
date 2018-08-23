//Author: Tushar Jaiswal
//Creation Date: 08/22/2018

/*There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.*/

public class Solution {
    public int NetworkDelayTime(int[,] times, int N, int K) {
        Dictionary<int, List<Tuple<int, int>>> graph = new Dictionary<int, List<Tuple<int, int>>>();
        Dictionary<int, int> nodeTime = new Dictionary<int, int>();
        SortedList<int, int> heap = new SortedList<int, int>(new DuplicateKeyComparer<int>());
        
        for(int i = 0; i < times.GetLength(0); i++)
        {
            if(!graph.ContainsKey(times[i, 0]))
            { graph.Add(times[i, 0], new List<Tuple<int, int>>()); }
            graph[times[i, 0]].Add(new Tuple<int, int>(times[i, 1], times[i, 2]));
        }
        heap.Add(0, K);
        
        while(heap.Count != 0)
        {
            int time = heap.Keys[0];
            int node = heap.Values[0];
            heap.RemoveAt(0);
            
            if(nodeTime.ContainsKey(node))
            { continue; }
            nodeTime.Add(node, time);
            if(graph.ContainsKey(node))
            {
                foreach(Tuple<int, int> edge in graph[node])
                {
                    if(!nodeTime.ContainsKey(edge.Item1))
                    { heap.Add(time + edge.Item2, edge.Item1); }
                }
            }
        }
        
        if(nodeTime.Count != N)
        { return -1; }
        
        int maxTime = -1;
        foreach(int time in nodeTime.Values)
        {
            if(time > maxTime)
            { maxTime = time; }
        }
        return maxTime;
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