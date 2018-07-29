//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the preorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its preorder traversal as: [1,3,5,6,2,4].
Note: Recursive solution is trivial, could you do it iteratively?*/

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
    public IList<int> Preorder(Node root) {
        List<int> pre = new List<int>();
        if(root != null) 
        {
            pre.Add(root.val); 
            foreach(Node node in root.children)
            {
                pre.AddRange(Preorder(node));
            }
        }
        return pre;
    }
}