//Author: Tushar Jaiswal
//Creation Date: 11/30/2020

/*Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:
    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)

Note:
    All keys and values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashMap library.
*/

/*Runtime Complexity: O(1) on average for all operations.
Space Complexity: O(n)*/

class MyHashMap {

    List<Pair<Integer, Integer>> [] buckets;
    int capacity;
    int size;
    double LOAD_FACTOR = 0.7;

    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 1000;
        size = 0;
        initializeBuckets();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);

        boolean found = false;
        for (Pair<Integer, Integer> pair : buckets[hash]) {
            if (pair.key == key) {
                pair.value = value;
                found = true;
            }
        }
        if (!found) {
            buckets[hash].add(new Pair<Integer, Integer>(key, value));
        }

        size++;

        if (size == capacity * LOAD_FACTOR) {
            rehash();
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        for (var pair : buckets[hash]) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);

        for (Pair<Integer, Integer> pair : buckets[hash]) {
            if (pair.key == key) {
                buckets[hash].remove(pair);
                break;
            }
        }

        size--;
    }

    private void initializeBuckets() {
        buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<Pair<Integer, Integer>>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    private void rehash() {
        List<Pair<Integer, Integer>>[] oldBuckets = buckets;
        capacity *= 2;
        initializeBuckets();

        for (int i = 0; i < oldBuckets.length; i++) {
            List<Pair<Integer, Integer>> list = oldBuckets[i];
            for (var pair : list) {
                put(pair.key, pair.value);
            }
        }
    }
}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
