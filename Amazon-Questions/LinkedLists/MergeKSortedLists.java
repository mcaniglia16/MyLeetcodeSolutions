class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)    return null;
        return DivideAndConquer(lists, 0, lists.length - 1);
    }
    
    private ListNode DivideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end) { 
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        ListNode l1 = DivideAndConquer(lists, start, (start + end) / 2);
        ListNode l2 = DivideAndConquer(lists, (start + end) / 2 + 1, end);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, curr = null;
        while (l1 != null && l2 != null) {
            ListNode l;
            if (l1.val < l2.val) {
                l = l1;
                l1 = l1.next;
            } else {
                l = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = l;
                curr = l;
            } else {
                curr.next = l;
                curr = curr.next;
            }
        }
        if (l1 != null)    curr.next = l1;
        if (l2 != null)    curr.next = l2;
        return head;
    }
}