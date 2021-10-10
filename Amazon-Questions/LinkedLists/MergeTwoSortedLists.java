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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode l3 = head;
        
        while (l1!=null && l2!=null) {
            // int val1 = (l1!=null) ? l1.val : 0;
            // int val2 = (l2!=null) ? l2.val : 0;
            
            // if (val1 < val2) {
            //     l3.next = l1;
            //     l1 = l1.next;
            // } else {
            //     l3.next = l2;
            //     l2 = l2.next;
            // }
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        //at this point, either l1 or l2 will still have a remaining node. Just need to add that node to l3
        l3.next = l1==null? l2:l1;
        
        return head.next;
    }
}