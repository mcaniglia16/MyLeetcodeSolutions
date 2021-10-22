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

 //      head
 // x    [1] -> [2] -> [3] -> null

 // prev  curr   next
 // x     [1] -> [2] -> [3] -> null

 //              curr
 // next         prev
 // x  <- [1]    [2] -> [3] -> null

 // null <- [1] <- [2] <- [3]  x
 //                      head

 // [3] -> [2] -> [1] -> null
class Solution {
    public ListNode reverseList(ListNode head) {

        // Method 1) iterative, O(N) time , O(1) space
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;   // save the next
            curr.next = prev;   // reverse next and previous
            
            prev = curr;        //
            curr = next;        // advance previous and current
        }
        return prev;

        //Method 2) recursive, O(N) time, O(N) space (stack)
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode reversedHead = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return reversedHead;
    }
}