//Author: Tushar Jaiswal
//Creation Date: 08/08/2018

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
The encoded string should be as compact as possible.
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
            TreeNode curr = queue.Dequeue();
            if(curr != null)
            {
                sb.Append(curr.val + ",");
                queue.Enqueue(curr.left);
                queue.Enqueue(curr.right);
            }
            else
            { sb.Append("n,"); }
        }
        
        return sb.ToString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        Queue<string> nodes = new Queue<string>(data.Split(new char[]{','}, StringSplitOptions.RemoveEmptyEntries).ToList());
        Queue<TreeNode> levelNodes = new Queue<TreeNode>();
        TreeNode root = null;
        string val = nodes.Dequeue();
        if(!val.Equals("n"))
        { 
            root = new TreeNode(int.Parse(val)); 
            levelNodes.Enqueue(root);
        }
            
        while(levelNodes.Count != 0)
        {
            int levelSize = levelNodes.Count;
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = levelNodes.Dequeue();
                val = nodes.Dequeue();
                if(!val.Equals("n"))
                { 
                    curr.left = new TreeNode(int.Parse(val)); 
                    levelNodes.Enqueue(curr.left);
                }
                else
                { curr.left = null; }
                val = nodes.Dequeue();
                if(!val.Equals("n"))
                { 
                    curr.right = new TreeNode(int.Parse(val)); 
                    levelNodes.Enqueue(curr.right);
                }
                else
                { curr.right = null; }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));