//Author: Tushar Jaiswal
//Creation Date: 09/03/2020

/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6*/

/*Runtime Complexity: O(total number of elements in all lists * log(number of lists))
Space Complexity: O(number of lists * log(number of lists))*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode MergeKLists(ListNode[] lists) {
        List<ListNode> allLists =  new List<ListNode>(lists);
        while (allLists.Count > 1) {
            List<ListNode> mergedLists = new List<ListNode>();
            for (int i = 0; i < allLists.Count; i += 2) {
                if (i + 1 < allLists.Count) {
                    mergedLists.Add(MergeTwoLists(allLists[i], allLists[i + 1]));
                } else {
                    mergedLists.Add(allLists[i]);
                }
            }
            allLists = mergedLists;
        }

        return allLists.Count == 1 ? allLists[0] : null;
    }


    private ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode merged = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return merged.next;
    }
}
