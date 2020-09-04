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
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> allLists = Arrays.asList(lists);
        while (allLists.size() > 1) {
            List<ListNode> mergedLists = new ArrayList<ListNode>();
            for (int i = 0; i < allLists.size(); i += 2) {
                if (i + 1 < allLists.size()) {
                    mergedLists.add(mergeTwoLists(allLists.get(i), allLists.get(i + 1)));
                } else {
                    mergedLists.add(allLists.get(i));
                }
            }
            allLists = mergedLists;
        }

        return allLists.size() == 1 ? allLists.get(0) : null;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
