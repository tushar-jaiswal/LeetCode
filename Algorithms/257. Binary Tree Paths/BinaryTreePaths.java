//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are: ["1->2->5", "1->3"]*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
        { 
            List<String> result = new ArrayList<String>();
            return result;
        }
        return traverse(root, "");
    }
    
    public List<String> traverse(TreeNode root, String path) {
        List<String> result = new ArrayList<String>();
        
        if(path == "")
        { 
            path = Integer.toString(root.val);
        }
        else
        {
            path += "->" + Integer.toString(root.val);
        }
        
        if(root.left == null && root.right == null)
        {
            result.add(path);
            return result;
        }
        
        List<String> left = new ArrayList<String>();
        List<String> right = new ArrayList<String>();
        if(root.left != null)
        {
            left = traverse(root.left, path);
        }
        if(root.right != null)
        {
            right = traverse(root.right, path);
        }
        for(String s : left)
        {
            result.add(s);
        }
        for(String s : right)
        {
            result.add(s);
        }
        
        return result;
    }
}