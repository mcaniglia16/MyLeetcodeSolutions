/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node curr = head;
        while (curr != null) {
            Node n = new Node(curr.val);
            map.put(curr, n);
            curr = curr.next;
        }
        
        curr = head;
        Node copy = new Node(0);
        while (curr != null) {
            copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}