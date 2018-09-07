//Author: Tushar Jaiswal
//Creation Date: 09/06/2018

/*Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.*/

public class Solution {
    public IList<string> FindItinerary(string[,] tickets) {
        Dictionary<string, SortedList<string, int>> graph = new Dictionary<string, SortedList<string, int>>();
        
        for(int i = 0; i < tickets.GetLength(0); i++)
        {
            if(!graph.ContainsKey(tickets[i, 0]))
            { graph.Add(tickets[i, 0], new SortedList<string, int>(new DuplicateKeyComparer())); }
            graph[tickets[i, 0]].Add(tickets[i, 1], 0);
        }
        
        List<string> result = new List<string>();
        DFS(graph, "JFK", result);
        return result;
    }
    
    private void DFS(Dictionary<string, SortedList<string, int>> graph, string node, List<string> result)
    {
        if(graph.ContainsKey(node))
        {
            while(graph[node].Count != 0)
            {
                string dest = graph[node].Keys[0];
                graph[node].RemoveAt(0);
                DFS(graph, dest, result);
            }
        }
        result.Insert(0, node);
    }
}

public class DuplicateKeyComparer : IComparer<string>
{
    public int Compare(string a, string b)
    {
        int result = a.CompareTo(b);
        return result == 0 ? 1 : result;
    }
}