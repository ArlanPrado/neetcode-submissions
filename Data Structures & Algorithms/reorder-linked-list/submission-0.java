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
    public void reorderList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while(head != null) {
            listNodes.add(head);
            head = head.next;
        }

        boolean flip = true;
        head = listNodes.getFirst();
        int i = 0;
        int val;
        int counter = 0;
        while(counter < listNodes.size()-1) {
            System.out.println(head.val);
            if (!flip) {
                val = listNodes.get(i).val;
            } else {
                val = listNodes.get(listNodes.size()-i-1).val;
                i++;
            }
            head.next = new ListNode(val);
            head = head.next;
            flip = !flip;
            counter++;
        }
        head.next = null;
    }
}
