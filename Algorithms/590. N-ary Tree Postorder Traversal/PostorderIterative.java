//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the postorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its postorder traversal as: [5,6,3,2,4,1].
Note: Recursive solution is trivial, could you do it iteratively?*/

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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if(root != null)
        {
            Deque<Node> stack = new ArrayDeque<Node>();
            stack.addFirst(root);
            
            while(!stack.isEmpty())
            {
                Node curr = stack.removeFirst();
                list.addFirst(curr.val);
                for(Node child : curr.children)
                {
                    stack.addFirst(child);
                }
            }
        }
        return list;
    }
}