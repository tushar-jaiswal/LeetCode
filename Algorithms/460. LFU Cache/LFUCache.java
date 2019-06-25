//Author: Tushar Jaiswal
//Creation Date: 06/25/2019

/*Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LFUCache cache = new LFUCache( 2 / capacity / );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4*/

class LFUCache {
    private int capacity;
    private HashMap<Integer, Integer> items;
    private HashMap<Integer, Integer> itemFrequencies;
    private HashMap<Integer, LinkedHashSet<Integer>> frequencyBuckets;
    private int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        items = new HashMap<Integer, Integer>();
        itemFrequencies = new HashMap<Integer, Integer>();
        frequencyBuckets = new HashMap<Integer, LinkedHashSet<Integer>>();
        min = -1;
        frequencyBuckets.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if(!items.containsKey(key))
        { return -1; }

        int frequency = itemFrequencies.get(key);
        itemFrequencies.put(key, frequency + 1);

        frequencyBuckets.get(frequency).remove(key);
        if(frequencyBuckets.get(frequency).size() == 0)
        {
            if(min != 1)
            { frequencyBuckets.remove(frequency); }
            if(frequency == min)
            { min++; }
        }
        if(!frequencyBuckets.containsKey(frequency + 1))
        { frequencyBuckets.put(frequency + 1, new LinkedHashSet<Integer>()); }
        frequencyBuckets.get(frequency + 1).add(key);

        return items.get(key);
    }

    public void put(int key, int value) {
        if(capacity <= 0)
        { return; }

        if(items.containsKey(key))
        {
            items.put(key, value);
            get(key);
            return;
        }
        items.put(key, value);
        itemFrequencies.put(key, 1);
        frequencyBuckets.get(1).add(key);

        if(items.size() > capacity)
        {
            int keyToEvict = frequencyBuckets.get(min).iterator().next();
            frequencyBuckets.get(min).remove(keyToEvict);
            if(frequencyBuckets.get(min).size() == 0)
            { frequencyBuckets.remove(min); }
            items.remove(keyToEvict);
            itemFrequencies.remove(keyToEvict);
        }
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
