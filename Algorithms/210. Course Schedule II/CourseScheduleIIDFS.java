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

class Solution {
    boolean[] visited;
    int order;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        order = numCourses - 1;
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            if(!graph.containsKey(prerequisites[i][1]))
            { graph.put(prerequisites[i][1], new ArrayList<Integer>()); }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            if(!visited[i])
            {
                if(!dfs(graph, i, new boolean[numCourses], result))
                { return new int[0]; }
            }
        }
        return result;
    }
    
    private boolean dfs(HashMap<Integer, List<Integer>> graph, int node, boolean[] encountered, int[] result)
    {
        encountered[node] = true;
        visited[node] = true;
        if(graph.containsKey(node))
        {
            for(int i : graph.get(node))
            {
                if(encountered[i])
                { return false; }
                if(visited[i])
                { continue; }
                boolean[] copy = new boolean[encountered.length];
                System.arraycopy(encountered, 0, copy, 0, encountered.length);
                if(!dfs(graph, i, copy, result))
                { return false; }
            }
        }
        result[order--] = node;
        return true;
    }
}