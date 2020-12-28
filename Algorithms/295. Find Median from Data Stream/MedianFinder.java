//Author: Tushar Jaiswal
//Creation Date: 12/27/2020

/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:
    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

Follow up:
    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/

/*Runtime Complexity: addNum is O(log(n)) and findMedian is O(1)
Space Complexity: O(n)*/

class MedianFinder {
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    /** initialize your data structure here. */
    public MedianFinder() {
        minPQ = new PriorityQueue<Integer>();
        maxPQ = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        addNumberInSortedOrder(minPQ, maxPQ, num);
        balancePriorityQueues(minPQ, maxPQ);
    }

    public double findMedian() {
        if (maxPQ.size() > minPQ.size()) {
            return (double) maxPQ.peek();
        } else {
            return ((double) maxPQ.peek() + minPQ.peek()) / 2;
        }
    }

    private void addNumberInSortedOrder(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ, int num) {
        maxPQ.add(num);
        minPQ.add(maxPQ.remove());
    }

    private void balancePriorityQueues(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ) {
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.add(minPQ.remove());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
