//Author: Tushar Jaiswal
//Creation Date: 08/08/2018

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
The encoded string should be as compact as possible.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.remove();
            if(curr != null)
            {
                sb.append(curr.val + ",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
            else
            { sb.append("n,"); }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
        Queue<TreeNode> levelNodes = new LinkedList<TreeNode>();
        TreeNode root = null;
        String val = nodes.remove();
        if(!val.equals("n"))
        { 
            root = new TreeNode(Integer.parseInt(val)); 
            levelNodes.add(root);
        }
            
        while(!levelNodes.isEmpty())
        {
            int levelSize = levelNodes.size();
            for(int i = 0; i < levelSize; i++)
            {
                TreeNode curr = levelNodes.remove();
                val = nodes.remove();
                if(!val.equals("n"))
                { 
                    curr.left = new TreeNode(Integer.parseInt(val)); 
                    levelNodes.add(curr.left);
                }
                else
                { curr.left = null; }
                val = nodes.remove();
                if(!val.equals("n"))
                { 
                    curr.right = new TreeNode(Integer.parseInt(val)); 
                    levelNodes.add(curr.right);
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