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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        
        int carry = 0;
        //OR because if one of the values is null, we just dont increment it and keep adding the numbers straight to the result list
        while (l1 != null || l2 != null) {
            int sum = (l1 !=null ? l1.val : 0) + (l2 !=null ? l2.val : 0) + carry;
            carry = sum/10;
            int remainder = sum % 10;
            
            ListNode new_node = new ListNode(remainder);
            l3.next = new_node;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        
        //if there is a carry at the end
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            l3.next = n;
            l3 = l3.next;
        }
        return head.next;
    }
}