//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.*/

/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node(){}
    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
}
*/

public class Solution {
    public IList<IList<int>> LevelOrder(Node root) {
        List<IList<int>> levelOrder = new List<IList<int>>();
        if(root != null)
        {
            Queue<Node> queue = new Queue<Node>();
            queue.Enqueue(root);
            
            while(queue.Count != 0)
            {
                int numLevelNodes = queue.Count;
                List<int> levelNodes = new List<int>();
                for(int i = 0; i < numLevelNodes; i++)
                {
                    Node curr = queue.Dequeue();
                    levelNodes.Add(curr.val);
                    foreach(Node child in curr.children)
                    { 
                        if(child != null)
                        { queue.Enqueue(child); }
                    }
                }
                levelOrder.Add(levelNodes);
            }
        }
        return levelOrder;
    }
}