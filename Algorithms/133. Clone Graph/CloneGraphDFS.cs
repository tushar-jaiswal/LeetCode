//Author: Tushar Jaiswal
//Creation Date: 08/28/2018

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization: Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/*/

/**
 * Definition for undirected graph.
 * public class UndirectedGraphNode {
 *     public int label;
 *     public IList<UndirectedGraphNode> neighbors;
 *     public UndirectedGraphNode(int x) { label = x; neighbors = new List<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Dictionary<int, UndirectedGraphNode> nodes = new Dictionary<int, UndirectedGraphNode>();
    
    public UndirectedGraphNode CloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode clone = null;
        if(node != null)
        {
            if(nodes.ContainsKey(node.label))
            {
                return nodes[node.label];
            }
            else
            {
                nodes.Add(node.label, new UndirectedGraphNode(node.label));
            }
            clone = nodes[node.label];
            foreach(UndirectedGraphNode neighbor in node.neighbors)
            {
                clone.neighbors.Add(CloneGraph(neighbor));
            }
        }
        return clone;
    }
}