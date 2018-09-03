//Author: Tushar Jaiswal
//Creation Date: 09/03/2018

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
    bool[] visited;
    
    public bool CanFinish(int numCourses, int[,] prerequisites) {
        visited = new bool[numCourses];
        List<int>[] graph = new List<int>[numCourses];
        for(int i = 0; i < prerequisites.GetLength(0); i++)
        {
            if(graph[prerequisites[i, 0]] == null)
            { graph[prerequisites[i, 0]] = new List<int>(); }
            graph[prerequisites[i, 0]].Add(prerequisites[i, 1]);
        }
        for(int i  = 0; i < numCourses; i++)
        {
            if(graph[i] != null && !visited[i])
            {
                if(!isPossible(graph, i, new bool[numCourses]))
                { return false; }
            }
        }
        return true;
    }
    
    private bool isPossible(List<int>[] graph, int node, bool[] encountered)
    {
        visited[node] = true;
        encountered[node] = true;
        foreach(int i in graph[node])
        {
            if(encountered[i])
            { return false; }
            if(visited[i])
            { return true; }
            if(graph[i] != null)
            { 
                bool[] copy = new bool[encountered.Length];
                Array.Copy(encountered, copy, encountered.Length);
                if(!isPossible(graph, i, copy))
                { return false; }
            }
        }
        return true;
    }
}