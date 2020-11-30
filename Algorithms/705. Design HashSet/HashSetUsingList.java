//Author: Tushar Jaiswal
//Creation Date: 11/29/2020

/*Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:
    add(value): Insert a value into the HashSet.
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)

Note:
    All values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashSet library.
*/

/*Runtime Complexity: O(1) on average for all operations.
Space Complexity: O(n)*/

class MyHashSet {

    Bucket[] buckets;
    int capacity;
    int size;
    double LOAD_FACTOR = 0.7;

    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1000;
        size = 0;
        initializeBuckets();
    }

    public void add(int key) {
        int hash = hash(key);
        buckets[hash].add(key);
        size++;

        if (size == capacity * LOAD_FACTOR) {
            rehash();
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        buckets[hash].remove(key);
        size--;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        return buckets[hash].contains(key);
    }

    private void initializeBuckets() {
        buckets = new Bucket[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    private void rehash() {
        Bucket[] oldBuckets = buckets;
        capacity *= 2;
        initializeBuckets();

        for (int i = 0; i < oldBuckets.length; i++) {
            for (int key : oldBuckets[i].getContainer()) {
                add(key);
            }
        }
    }

    public int size() {
        return size;
    }
}

class Bucket {
    private List<Integer> container;

    public List<Integer> getContainer() {
        return this.container;
    }

    public Bucket() {
        container = new ArrayList<Integer>();
    }

    public void add(Integer key) {
        if (container.contains(key)) {
            return;
        }
        container.add(key);
    }

    public void remove(Integer key) {
        container.remove(key);
    }

    public boolean contains(Integer key) {
        return container.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
