//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
//

class DoublyLinkedNode{
    DoublyLinkedNode next;
    DoublyLinkedNode prev;
    int value;
    int key;

    public DoublyLinkedNode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    HashMap<Integer, DoublyLinkedNode> mem=new HashMap();
    DoublyLinkedNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void printCache(String method){
        System.out.println(method);
        DoublyLinkedNode node = head;
        System.out.println("- - - - - - - - - ");
        while(node!=null){
            System.out.println(node.key + ": " + node.value);
            node = node.next;
        }
        System.out.println("- - - - - - - - - ");
    }

    public void moveToHead(DoublyLinkedNode node){
        DoublyLinkedNode current;
        if(head.key == node.key){
            return;
        }
        if(tail.key == node.key){
            tail = tail.prev;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        head.prev = node;
        node.prev = null;
        node.next = head;
        head = node;
    }

    public void removeTail(){
        if(tail.prev != null){
            mem.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
        } else {
            tail = null;
            head = null;
            mem.clear();
        }
    }

    public int get(int key) {
        if(!mem.containsKey(key)){
            return -1;
        }
        DoublyLinkedNode node = mem.get(key);
        moveToHead(node);
        printCache("GET " + key);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedNode node;
        int tailKey;
        if(mem.containsKey(key)){
            node = mem.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new DoublyLinkedNode(key, value);
            checkHeadTail(node);
            checkConstraint();
            checkHeadTail(node);
            mem.put(key, node);
            moveToHead(node);
        }
        printCache("PUT " + key + ":" + value);
    }

    public void checkConstraint(){
        if(mem.size() + 1 > capacity){
            removeTail();
        }
    }

    public void checkHeadTail(DoublyLinkedNode node){
        if(mem.size() == 0){
            head = node;
            tail = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */