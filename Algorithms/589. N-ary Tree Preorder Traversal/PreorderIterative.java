//Author: Tushar Jaiswal
//Creation Date: 07/29/2016

/*Given an n-ary tree, return the preorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its preorder traversal as: [1,3,5,6,2,4].
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
    public List<Integer> preorder(Node root) {
        List<Integer> pre = new ArrayList<Integer>();
        if(root != null) 
        {
            Deque<Node> stack = new ArrayDeque<Node>();
            stack.addFirst(root);
            
            while(!stack.isEmpty())
            {
                Node node = stack.removeFirst();
                pre.add(node.val);
                for(int i = node.children.size() - 1; i >= 0; i--)
                {
                    stack.addFirst(node.children.get(i));
                }
            }
        }
        return pre;
    }
}