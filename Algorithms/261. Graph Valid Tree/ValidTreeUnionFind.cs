//Author: Tushar Jaiswal
//Creation Date: 09/08/2018

 /*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 Notice: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 Example:
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.*/

public class Solution
	{
		static void Main(string[] args)
		{
			int[,] arr = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
			Console.WriteLine(ValidTree(5, arr));
			arr = new int[,] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
			Console.WriteLine(ValidTree(5, arr));
			arr = new int[,] { { 0, 1 }, { 0, 2 }, { 3, 4 } };
			Console.WriteLine(ValidTree(5, arr));
			arr = new int[,] { { 0, 0 } };
			Console.WriteLine(ValidTree(1, arr));
		}

		public static bool ValidTree(int n, int[,] edges)
		{
			if (n - 1 != edges.GetLength(0) || n == 0)
			{ return false; }
			int[] parent = new int[n];
			for(int i = 0; i < n; i++)
			{ parent[i] = -1; }
			for (int i = 0; i < edges.GetLength(0); i++)
			{
				int x = Find(parent, edges[i, 0]);
				int y = Find(parent, edges[i, 1]);
				if(x == y)
				{ return false; }
				Union(parent, x, y);
			}
			return true;
		}

		public static int Find(int[] parent, int node)
		{
			if(parent[node] == -1)
			{ return node; }
			return Find(parent, parent[node]);
		}

		public static void Union(int[] parent, int x, int y)
		{
			int xParent = Find(parent, x);
			int yParent = Find(parent, y);
			parent[xParent] = yParent;
		}
	}