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
    public bool CanFinish(int numCourses, int[,] prerequisites) {
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.GetLength(0); i++)
        {
            if(!graph.ContainsKey(prerequisites[i, 1]))
            { graph.Add(prerequisites[i, 1], new List<int>()); }
            graph[prerequisites[i, 1]].Add(prerequisites[i, 0]);
            inDegree[prerequisites[i, 0]]++;
        }
        Queue<int> queue = new Queue<int>();
        for(int i = 0; i < inDegree.Length; i++)
        {
            if(inDegree[i] == 0)
            { queue.Enqueue(i); }
        }
        
        int countNodes = 0;
        while(queue.Count != 0)
        {
            countNodes++;
            int course = queue.Dequeue();
            if(graph.ContainsKey(course))
            {
                foreach(int i in graph[course])
                {
                    if(--inDegree[i] == 0)
                    { queue.Enqueue(i); }
                }
            }
        }
        
        return countNodes == numCourses;
    }
}