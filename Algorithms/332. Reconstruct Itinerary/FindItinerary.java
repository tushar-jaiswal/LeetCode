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

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        
        for(int i = 0; i < tickets.length; i++)
        {
            if(!graph.containsKey(tickets[i][0]))
            { graph.put(tickets[i][0], new PriorityQueue<String>()); }
            graph.get(tickets[i][0]).offer(tickets[i][1]);
        }
        
        List<String> result = new ArrayList<String>();
        dfs(graph, "JFK", result);
        return result;
    }
    
    private void dfs(HashMap<String, PriorityQueue<String>> graph, String node, List<String> result)
    {
        PriorityQueue<String> heap = graph.get(node);
        while(heap != null && !heap.isEmpty())
        {
            dfs(graph, heap.poll(), result);
        }
        result.add(0, node);
    }
}