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

class Solution {
    boolean[] visited;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        List[] graph = new List[numCourses];
        for(int i = 0; i < prerequisites.length; i++)
        {
            if(graph[prerequisites[i][0]] == null)
            { graph[prerequisites[i][0]] = new ArrayList<Integer>(); }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses; i++)
        {
            if(graph[i] != null && !visited[i])
            {
                if(!isPossible(graph, i, new boolean[numCourses]))
                { return false; }
            }
        }
        return true;
    }
    
    private boolean isPossible(List[] graph, int node, boolean[] encountered)
    {
        visited[node] = true;
        encountered[node] = true;
        for(int i = 0; i < graph[node].size(); i++)
        {
            int course = (int)graph[node].get(i);
            if(encountered[course])
            { return false; }
            if(visited[course])
            { return true; }
            if(graph[course] != null)
            { 
                if(!isPossible(graph, course, encountered))
                { return false; }
            }
        }
        return true;
    }
}