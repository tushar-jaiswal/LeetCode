//Author: Tushar Jaiswal
//Creation Date: 09/23/2018

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up: Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 <capacity> );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4*/

class LRUCache {
    int capacity;
    HashMap<Integer, DoublyLinkedListNode> map;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DoublyLinkedListNode>();
        head = new DoublyLinkedListNode(0, 0);
        tail = new DoublyLinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            DoublyLinkedListNode node = map.get(key);
            removeFromPosition(node);
            moveToHead(node);
            return node.val;
        }
        else
        { return -1; }
    }
    
    public void put(int key, int value) {
        DoublyLinkedListNode node;
        if(map.containsKey(key))
        {
            node = map.get(key);
            node.val = value;
            removeFromPosition(node);
        }
        else
        { 
            node = new DoublyLinkedListNode(key, value); 
            map.put(key, node);
        }
        moveToHead(node);
        if(map.size() > capacity)
        {
            DoublyLinkedListNode removed = removeFromTail();
            map.remove(removed.key);
        }
    }
    
    private void removeFromPosition(DoublyLinkedListNode node)
    {
        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DoublyLinkedListNode node)
    {
        DoublyLinkedListNode temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }
    
    private DoublyLinkedListNode removeFromTail()
    {
        DoublyLinkedListNode nodeToRemove = tail.prev;
        DoublyLinkedListNode temp = nodeToRemove.prev;
        temp.next = tail;
        tail.prev = temp;
        return nodeToRemove;
    }
}

class DoublyLinkedListNode
{
    int key;
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    
    public DoublyLinkedListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */