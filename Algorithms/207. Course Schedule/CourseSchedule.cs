//Author: Tushar Jaiswal
//Creation Date: 09/01/2018

/*There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.*/

public class Solution {
    HashSet<int> visited = new HashSet<int>();
    
    public bool CanFinish(int numCourses, int[,] prerequisites) {
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        for(int i = 0; i < prerequisites.GetLength(0); i++)
        {
            if(!graph.ContainsKey(prerequisites[i, 0]))
            { graph.Add(prerequisites[i, 0], new List<int>()); }
            graph[prerequisites[i, 0]].Add(prerequisites[i, 1]);
        }
        foreach(int i in graph.Keys)
        {
            if(!visited.Contains(i))
            {
                if(!isPossible(graph, i, new HashSet<int>()))
                { return false; }
            }
        }
        return true;
    }
    
    private bool isPossible(Dictionary<int, List<int>> graph, int node, HashSet<int> encountered)
    {
        visited.Add(node);
        encountered.Add(node);
        foreach(int i in graph[node])
        {
            if(encountered.Contains(i))
            { return false; }
            if(visited.Contains(i))
            { return true; }
            if(graph.ContainsKey(i))
            { 
                if(!isPossible(graph, i, new HashSet<int>(encountered)))
                { return false; }
            }
        }
        return true;
    }
}