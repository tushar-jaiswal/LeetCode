import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		System.out.println(validTree(5, arr));
		arr = new int[][]{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree(5, arr));
	}
	
	public static boolean validTree(int n, int[][] edges)	
	{
		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		int[] degree = new int[n];
		for (int i = 0; i < edges.length; i++)
		{
			if (!graph.containsKey(edges[i][0]))
			{ graph.put(edges[i][0], new ArrayList<Integer>()); }
			if (!graph.containsKey(edges[i][1]))
			{ graph.put(edges[i][1], new ArrayList<Integer>()); }
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
			degree[edges[i][0]]++;
			degree[edges[i][1]]++;
		}

		Queue<Integer> nodes = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
		{
			if (degree[i] == 1)
			{ nodes.offer(i); }
		}

		while (n > 0 && !nodes.isEmpty())
		{
			n--;
			int node = nodes.poll();
			for(int i : graph.get(node))
			{
				degree[i]--;
				if (degree[i] == 1)
				{ nodes.offer(i); }
			}
		}
		return n == 0;
	}
}
