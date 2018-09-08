import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		System.out.println(validTree(5, arr));
		arr = new int[][]{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree(5, arr));
		arr = new int[][] { { 0, 1 }, { 0, 2 }, { 3, 4 } };
		System.out.println(validTree(5, arr));
	}
	
	public static boolean validTree(int n, int[][] edges)	
	{
		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < edges.length; i++)
		{
			if (!graph.containsKey(edges[i][0]))
			{ graph.put(edges[i][0], new ArrayList<Integer>()); }
			if (!graph.containsKey(edges[i][1]))
			{ graph.put(edges[i][1], new ArrayList<Integer>()); }
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		boolean[] visited = new boolean[n];
		if (!dfs(graph, edges[0][0], -1, visited))
		{ return false; }
		for(boolean visit : visited)
		{
			if (!visit)
			{ return false; }
		}
		return true;
	}
	
	public static boolean dfs(HashMap<Integer, List<Integer>> graph, int node, int parent, boolean[] visited)
	{
		visited[node] = true;
		for(int neighbor : graph.get(node))
		{
			if(!visited[neighbor])
			{
				if (!dfs(graph, neighbor, node, visited))
				{ return false; }
			}
			else if(neighbor != parent)
			{ return false; }
		}
		return true;
	}
}
