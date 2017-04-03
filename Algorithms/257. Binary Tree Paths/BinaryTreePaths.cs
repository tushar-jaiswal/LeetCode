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
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<string> BinaryTreePaths(TreeNode root) {
        if(root == null)
        { 
            List<string> result = new List<string>();
            return result;
        }
        return Traverse(root, "");
    }
    
    public List<string> Traverse(TreeNode root, string path) 
    {
        List<string> result = new List<string>();
        
        if(path == "")
        { 
            path = root.val.ToString();
        }
        else
        {
            path += "->" + root.val.ToString();
        }
        
        if(root.left == null && root.right == null)
        {
            result.Add(path);
            return result;
        }
        
        List<string> left = new List<string>();
        List<string> right = new List<string>();
        if(root.left != null)
        {
            left = Traverse(root.left, path);
        }
        if(root.right != null)
        {
            right = Traverse(root.right, path);
        }
        foreach(string s in left)
        {
            result.Add(s);
        }
        foreach(string s in right)
        {
            result.Add(s);
        }
        
        return result;
    }
}