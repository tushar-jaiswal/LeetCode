//Author: Tushar Jaiswal
//Creation Date: 08/18/2018

/*Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.*/

public class KthLargest {

    private int k;
    private SortedList<int, int> sortedList;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        sortedList = new SortedList<int, int>();
        foreach(int i in nums)
        {
            this.Add(i);
        }
    }
    
    public int Add(int val) {
        int size = 0;
        foreach(int count in sortedList.Values)
        { size += count; }
        if(size < k || val > sortedList.Keys[0])
        { 
            if(sortedList.ContainsKey(val))
            {
                sortedList[val]++;
            }
            else
            { sortedList.Add(val, 1); }
            size++;
        }
        if(size > k)
        { 
            KeyValuePair<int, int> kvp = sortedList.First(); 
            if(kvp.Value > 1)
            {
                sortedList[kvp.Key]--;
            }
            else
            { sortedList.RemoveAt(0); }
        }
        return sortedList.Keys[0];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.Add(val);
 */