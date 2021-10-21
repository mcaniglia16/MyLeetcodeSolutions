public class LRUCache {

    class Node {
      int key;
      int value;
      Node prev;
      Node next;
    }
  
    private void add(Node node) {
      //Always add the new node right after head.
      node.prev = head;
      node.next = head.next;
  
      head.next.prev = node;
      head.next = node;
    }
  
    private void remove(Node node){
      //Remove an existing node from the linked list.
      Node prev = node.prev;
      Node next = node.next;
  
      prev.next = next;
      next.prev = prev;
    }
  
    private void moveToHead(Node node){
      // Move certain node in between to the head.
      remove(node);
      add(node);
    }
  
    private Node popTail() {
      //Pop the current tail.
      Node res = tail.prev;
      remove(res);
      return res;
    }
  
    //////////////////////////////////////////////////////////////////////

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    Node head;
    Node tail;
  
    public LRUCache(int capacity) {
      this.size = 0;
      this.capacity = capacity;
  
      head = new Node();
      head.prev = null;
  
      tail = new Node();
      tail.next = null;
  
      head.next = tail;
      tail.prev = head;
    }
  
    public int get(int key) {
      Node node = cache.get(key);
      if (node == null) return -1;
  
      // move the accessed node to the head;
      moveToHead(node);
  
      return node.value;
    }
  
    public void put(int key, int value) {
      Node node = cache.get(key);
  
      if(node == null) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
  
        cache.put(key, newNode);
        addNode(newNode);
  
        ++size;
  
        if(size > capacity) {
          // pop the tail
          Node tail = popTail();
          cache.remove(tail.key);
          --size;
        }
      } else {
        // update the value.
        node.value = value;
        moveToHead(node);
      }
    }
  }