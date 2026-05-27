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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode newListNode = new ListNode();
        ListNode temp = newListNode;
        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                temp.val = val1;
                list1 = list1.next;
            } else {
                temp.val = val2;
                list2 = list2.next;     
            }
            if (list1 != null || list2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return newListNode;
    }
}