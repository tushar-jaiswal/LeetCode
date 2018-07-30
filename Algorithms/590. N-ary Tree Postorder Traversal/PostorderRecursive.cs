//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the postorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its postorder traversal as: [5,6,3,2,4,1].
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
    public IList<int> Postorder(Node root) {
        List<int> list = new List<int>();
        if(root != null)
        {
            foreach(Node child in root.children)
            {
                list.AddRange(Postorder(child));
            }
            list.Add(root.val);
        }
        return list;
    }
}