//Author: Tushar Jaiswal
//Creation Date: 09/04/2018

/*For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
Format: The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :
Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3 
Output: [1]

Example 2 :
Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5 
Output: [3, 4]

Note:
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.*/

public class Solution {
    public IList<int> FindMinHeightTrees(int n, int[,] edges) {
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        int[] degree = new int[n];
        
        for(int i = 0; i < edges.GetLength(0); i++)
        {
            if(!graph.ContainsKey(edges[i, 0]))
            { graph.Add(edges[i, 0], new List<int>()); }
            if(!graph.ContainsKey(edges[i, 1]))
            { graph.Add(edges[i, 1], new List<int>()); }
            graph[edges[i, 0]].Add(edges[i, 1]);
            graph[edges[i, 1]].Add(edges[i, 0]);
            degree[edges[i, 0]]++;
            degree[edges[i, 1]]++;
        }
        List<int> result = new List<int>();
        Queue<int> queue = new Queue<int>();
        
        for(int i = 0; i < n; i++)
        { 
            if(degree[i] == 1)
            { queue.Enqueue(i); }
        }
        while(queue.Count != 0)
        {
            if(n <= 2)
            {
                while(queue.Count != 0)
                { result.Add(queue.Dequeue()); }
                break;
            }
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                int node = queue.Dequeue();
                foreach(int curr in graph[node])
                {
                    degree[curr]--;
                    if(degree[curr] == 1)
                    { queue.Enqueue(curr); }
                }
            }
            n -= size;
        }
        if(result.Count == 0)
        { result.Add(0); }
        return result;
    }
}