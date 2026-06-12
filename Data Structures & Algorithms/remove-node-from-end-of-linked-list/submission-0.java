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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        1. put the list nodes in a list
        2. do the operation of list.length()-n = v
        3. if v is 0 then return 1 listNode
        4. if v is end of list then get v - 1 and set the listnode.next = null, 
        5. if in the middle, then get v + 1, get v - 1.next = v+1
        */
        
        List<ListNode> listNodes = new ArrayList<>();
        //get the lists in an array
        ListNode temp = head;
        while(temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }

        int pos = listNodes.size() - n;
        if (pos == 0) {
            if (listNodes.size() == 1) {
                return null;
            }
            return listNodes.get(1);
        } else if (pos == listNodes.size() - 1) {
            if (listNodes.size() == 1) {
                return null;
            }
            listNodes.get(pos-1).next = null;
            return head;
        } else {
            ListNode before = listNodes.get(pos - 1);
            ListNode after = listNodes.get(pos + 1);
            before.next = after;
        }
        return head;
    }
}
