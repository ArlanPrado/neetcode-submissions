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
    public ListNode reverseList(ListNode head) {
        /*
        0 (val 1, next -> val 2 next -> val 3 next ->  
        val 1, next <- val 2 next
        */
        ListNode newHead = null;
        while(head != null) {
            if (null != newHead) {
                ListNode prevHead = newHead;
                newHead = new ListNode(head.val, prevHead);
            } else {
                newHead = new ListNode(head.val);
            }
            head = head.next;
        }
        return newHead;
    }
}
