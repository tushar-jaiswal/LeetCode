public class Solution
	{
		static void Main(string[] args)
		{
			int[,] arr = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
			Console.WriteLine(ValidTree(5, arr));
			arr = new int[,]{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
			Console.WriteLine(ValidTree(5, arr));
			arr = new int[,] { { 0, 1 }, { 0, 2 }, { 3, 4 } };
			Console.WriteLine(ValidTree(5, arr));
		}

		public static bool ValidTree(int n, int[,] edges)
		{
			Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
			for (int i = 0; i < edges.GetLength(0); i++)
			{
				if (!graph.ContainsKey(edges[i, 0]))
				{ graph.Add(edges[i, 0], new List<int>()); }
				if (!graph.ContainsKey(edges[i, 1]))
				{ graph.Add(edges[i, 1], new List<int>()); }
				graph[edges[i, 0]].Add(edges[i, 1]);
				graph[edges[i, 1]].Add(edges[i, 0]);
			}
			bool[] visited = new bool[n];
			if (!DFS(graph, edges[0, 0], -1, visited))
			{ return false; }
			foreach(bool visit in visited)
			{
				if (!visit)
				{ return false; }
			}
			return true;
		}

		public static bool DFS(Dictionary<int, List<int>> graph, int node, int parent, bool[] visited)
		{
			visited[node] = true;
			foreach(int neighbor in graph[node])
			{
				if(!visited[neighbor])
				{
					if (!DFS(graph, neighbor, node, visited))
					{ return false; }
				}
				else if(neighbor != parent)
				{ return false; }
			}
			return true;
		}
	}