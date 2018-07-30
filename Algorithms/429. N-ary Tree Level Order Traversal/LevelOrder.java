//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
        if(root != null)
        {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            
            while(!queue.isEmpty())
            {
                int numLevelNodes = queue.size();
                List<Integer> levelNodes = new ArrayList<Integer>();
                for(int i = 0; i < numLevelNodes; i++)
                {
                    Node curr = queue.remove();
                    levelNodes.add(curr.val);
                    for(Node child : curr.children)
                    { 
                        if(child != null)
                        { queue.add(child); }
                    }
                }
                levelOrder.add(levelNodes);
            }
        }
        return levelOrder;
    }
}