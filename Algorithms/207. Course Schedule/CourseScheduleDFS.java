//Author: Tushar Jaiswal
//Creation Date: 08/29/2018

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
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            if(!graph.containsKey(prerequisites[i][1]))
            { graph.put(prerequisites[i][1], new ArrayList<Integer>()); }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i : graph.keySet())
        {
            if(!visited[i])
            {
                if(!isPossible(graph, i, new boolean[numCourses]))
                { return false; }
            }
        }
        return true;
    }
    
    private boolean isPossible(HashMap<Integer, List<Integer>> graph, int node, boolean[] encountered)
    {
        visited[node] = true;
        encountered[node] = true;
        for(int i : graph.get(node))
        {
            if(encountered[i])
            { return false; }
            if(visited[i])
            { continue; }
            if(graph.containsKey(i))
            { 
                boolean[] copy = new boolean[encountered.length];
                System.arraycopy(encountered, 0, copy, 0, encountered.length);
                if(!isPossible(graph, i, copy))
                { return false; }
            }
        }
        return true;
    }
}