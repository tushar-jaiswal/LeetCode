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

public class LFUCache {
    int capacity;
    Dictionary<int, int> items;
    Dictionary<int, int> itemFrequencies;
    Dictionary<int, List<int>> frequencyBuckets;
    int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        items = new Dictionary<int, int>();
        itemFrequencies = new Dictionary<int, int>();
        frequencyBuckets = new Dictionary<int, List<int>>();//ToDo: Use LinkedHashSet here instead of List. Implement LinkedHashSet in C#
        min = -1;
        frequencyBuckets.Add(1, new List<int>());
    }

    public int Get(int key) {
        if(!items.ContainsKey(key))
        { return -1; }

        int frequency = itemFrequencies[key];
        itemFrequencies[key]++;

        frequencyBuckets[frequency].Remove(key);//O(n) - C# doesn't have LinkedHashSet which would do this in O(1) ToDo: Implement LinkedHashSet in C#
        if(frequencyBuckets[frequency].Count == 0)
        {
            if(min != 1)
            { frequencyBuckets.Remove(frequency); }
            if(frequency == min)
            { min++; }
        }
        if(!frequencyBuckets.ContainsKey(frequency + 1))
        { frequencyBuckets.Add(frequency + 1, new List<int>()); }
        frequencyBuckets[frequency + 1].Add(key);

        return items[key];
    }

    public void Put(int key, int value) {
        if(capacity <= 0)
        { return; }

        if(items.ContainsKey(key))
        {
            items[key] = value;
            Get(key);
            return;
        }
        items[key] = value;
        itemFrequencies[key] = 1;
        frequencyBuckets[1].Add(key);

        if(items.Count > capacity)
        {
            int keyToEvict = frequencyBuckets[min][0];
            frequencyBuckets[min].RemoveAt(0);
            if(frequencyBuckets[min].Count == 0)
            { frequencyBuckets.Remove(min); }
            items.Remove(keyToEvict);
            itemFrequencies.Remove(keyToEvict);
        }
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */
