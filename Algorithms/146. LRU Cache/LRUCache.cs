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

public class LRUCache {
    int capacity;
    Dictionary<int, DoublyLinkedListNode> dict;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dict = new Dictionary<int, DoublyLinkedListNode>();
        head = new DoublyLinkedListNode(0, 0);
        tail = new DoublyLinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int Get(int key) {
        if(dict.ContainsKey(key))
        {
            DoublyLinkedListNode node = dict[key];
            RemoveFromPosition(node);
            MoveToHead(node);
            return node.val;
        }
        else
        { return -1; }
    }
    
    public void Put(int key, int value) {
        DoublyLinkedListNode node;
        if(dict.ContainsKey(key))
        {
            node = dict[key];
            node.val = value;
            RemoveFromPosition(node);
        }
        else
        { 
            node = new DoublyLinkedListNode(key, value); 
            dict[key] = node;
        }
        MoveToHead(node);
        if(dict.Keys.Count > capacity)
        {
            DoublyLinkedListNode removed = RemoveFromTail();
            dict.Remove(removed.key);
        }
    }
    
    private void RemoveFromPosition(DoublyLinkedListNode node)
    {
        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void MoveToHead(DoublyLinkedListNode node)
    {
        DoublyLinkedListNode temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }
    
    private DoublyLinkedListNode RemoveFromTail()
    {
        DoublyLinkedListNode nodeToRemove = tail.prev;
        DoublyLinkedListNode temp = nodeToRemove.prev;
        temp.next = tail;
        tail.prev = temp;
        return nodeToRemove;
    }
}

public class DoublyLinkedListNode
{
    public int key;
    public int val;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;
    
    public DoublyLinkedListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */