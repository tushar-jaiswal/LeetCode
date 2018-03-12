//Author: Tushar Jaiswal
//Creation Date: 03/12/2018

/*Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?

Note:
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null)
        {
            TreeLinkNode headChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = headChild;
            while(root != null)
            {
                if(root.left != null)
                {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if(root.right != null)
                {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = headChild.next;
        }
    }
}