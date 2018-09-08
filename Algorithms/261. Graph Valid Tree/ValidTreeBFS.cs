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
			Queue<Tuple<int, int>> queue = new Queue<Tuple<int, int>>();
			queue.Enqueue(new Tuple<int, int>(edges[0, 0], -1));
			
			while(queue.Count != 0)
			{
				Tuple<int, int> tpl = queue.Dequeue();
				int node = tpl.Item1;
				int parent = tpl.Item2;
				visited[node] = true;
				foreach (int neighbor in graph[node])
				{
					if (!visited[neighbor])
					{ queue.Enqueue(new Tuple<int, int>(neighbor, node)); }
					else if (neighbor != parent)
					{ return false; }
				}
			}
			foreach (bool visit in visited)
			{
				if (!visit)
				{ return false; }
			}
			return true;
		}
	}