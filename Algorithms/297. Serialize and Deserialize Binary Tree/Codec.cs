//Author: Tushar Jaiswal
//Creation Date: 03/14/2018

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
For example, you may serialize the following tree
    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        while(queue.Count != 0)
        {
            int levelSize = queue.Count;
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.Dequeue();
                if(node != null)
                {
                    sb.Append(node.val + ",");
                    queue.Enqueue(node.left);
                    queue.Enqueue(node.right);
                }
                else
                {
                    sb.Append("null,");
                }
            }
        }
        return sb.ToString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        TreeNode root = null;
        Queue<string> nodes = new Queue<string>(data.Split(new char[]{','}, StringSplitOptions.RemoveEmptyEntries).ToList());
        Queue<TreeNode> ancestorNodes = new Queue<TreeNode>();
        
        string rootVal = nodes.Dequeue();
        if(!rootVal.Equals("null"))
        {
            root = new TreeNode(int.Parse(rootVal));
            ancestorNodes.Enqueue(root);
        }
        
        while(nodes.Count != 0)
        {
            int ancestorLevelSize = ancestorNodes.Count;
            for(int i = 0; i < ancestorLevelSize; i++)
            {
                TreeNode currentAncestorNode = ancestorNodes.Dequeue();
                string val = nodes.Dequeue();
                if(val.Equals("null"))
                { currentAncestorNode.left = null; }
                else
                { 
                    TreeNode node = new TreeNode(int.Parse(val));
                    currentAncestorNode.left = node; 
                    ancestorNodes.Enqueue(node);
                }
                
                val = nodes.Dequeue();
                if(val.Equals("null"))
                { currentAncestorNode.right = null; }
                else
                {
                    TreeNode node = new TreeNode(int.Parse(val));
                    currentAncestorNode.right = node; 
                    ancestorNodes.Enqueue(node);
                }
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));