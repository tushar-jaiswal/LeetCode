//Author: Tushar Jaiswal
//Creation Date: 09/03/2018

/*There are a total of n courses you have to take, labeled from 0 to n-1. Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses. There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
             
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.*/

public class Solution {
    bool[] visited;
    int order;
    
    public int[] FindOrder(int numCourses, int[,] prerequisites) {
        visited = new bool[numCourses];
        order = numCourses - 1;
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        
        for(int i = 0; i < prerequisites.GetLength(0); i++)
        {
            if(!graph.ContainsKey(prerequisites[i, 1]))
            { graph.Add(prerequisites[i, 1], new List<int>()); }
            graph[prerequisites[i, 1]].Add(prerequisites[i, 0]);
        }
        
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            if(!visited[i])
            {
                if(!DFS(graph, i, new bool[numCourses], result))
                { return new int[0]; }
            }
        }
        return result;
    }
    
    private bool DFS(Dictionary<int, List<int>> graph, int node, bool[] encountered, int[] result)
    {
        encountered[node] = true;
        visited[node] = true;
        if(graph.ContainsKey(node))
        {
            foreach(int i in graph[node])
            {
                if(encountered[i])
                { return false; }
                if(visited[i])
                { continue; }
                bool[] copy = new bool[encountered.Length];
                Array.Copy(encountered, copy, encountered.Length);
                if(!DFS(graph, i, copy, result))
                { return false; }
            }
        }
        result[order--] = node;
        return true;
    }
}