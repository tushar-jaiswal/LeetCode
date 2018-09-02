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
    HashSet<Integer> visited = new HashSet<Integer>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            if(!graph.containsKey(prerequisites[i][0]))
            { graph.put(prerequisites[i][0], new ArrayList<Integer>()); }
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i : graph.keySet())
        {
            if(!visited.contains(i))
            {
                if(!isPossible(graph, i, new HashSet<Integer>()))
                { return false; }
            }
        }
        return true;
    }
    
    private boolean isPossible(HashMap<Integer, List<Integer>> graph, int node, HashSet<Integer> encountered)
    {
        visited.add(node);
        encountered.add(node);
        for(int i : graph.get(node))
        {
            if(encountered.contains(i))
            { return false; }
            if(visited.contains(i))
            { return true; }
            if(graph.containsKey(i))
            { 
                if(!isPossible(graph, i, new HashSet<Integer>(encountered)))
                { return false; }
            }
        }
        return true;
    }
}