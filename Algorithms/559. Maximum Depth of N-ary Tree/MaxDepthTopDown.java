//Author: Tushar Jaiswal
//Creation Date: 08/06/2018

/*Given a n-ary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: The depth of the tree is at most 1000. The total number of nodes is at most 5000.*/

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
    private int maxDepth = 0; 
    public int maxDepth(Node root) {
        findDepth(root, 1);
        return maxDepth;
    }
    
    public void findDepth(Node root, int depth)
    {
        if(root == null) { return; }
        
        if(root.children.size() == 0)
        { maxDepth = Math.max(maxDepth, depth); }
        
        for(Node child : root.children)
        { findDepth(child, depth + 1); }
    }
}