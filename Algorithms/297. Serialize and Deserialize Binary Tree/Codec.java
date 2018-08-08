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
            TreeNode node = queue.remove();
            if(node != null)
            {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else
            {
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
        Queue<TreeNode> ancestorNodes = new LinkedList<TreeNode>();
        
        String rootVal = nodes.remove();
        if(!rootVal.equals("null"))
        {
            root = new TreeNode(Integer.parseInt(rootVal));
            ancestorNodes.add(root);
        }
        
        while(!nodes.isEmpty())
        {
            int ancestorLevelSize = ancestorNodes.size();
            for(int i = 0; i < ancestorLevelSize; i++)
            {
                TreeNode currentAncestorNode = ancestorNodes.remove();
                String val = nodes.remove();
                if(val.equals("null"))
                { currentAncestorNode.left = null; }
                else
                { 
                    currentAncestorNode.left = new TreeNode(Integer.parseInt(val));
                    ancestorNodes.add(currentAncestorNode.left);
                }
                
                val = nodes.remove();
                if(val.equals("null"))
                { currentAncestorNode.right = null; }
                else
                {
                    currentAncestorNode.right = new TreeNode(Integer.parseInt(val));
                    ancestorNodes.add(currentAncestorNode.right);
                }
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));