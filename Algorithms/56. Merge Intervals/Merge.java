//Author: Tushar Jaiswal
//Creation Date: 09/15/2018

/*Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        for(Interval interval : intervals)
        { heap.offer(interval); }
        List<Interval> result = new ArrayList<Interval>();
        Interval i1 = heap.poll();
        while(!heap.isEmpty())
        {
            Interval i2 = heap.poll();
            if(i1.end >= i2.start)
            {
                Interval merged = new Interval(i1.start, Math.max(i1.end, i2.end));
                i1 = merged;
            }
            else
            {
                result.add(i1);
                i1 = i2;
            }
        }
        if(i1 != null)
        { result.add(i1); }
        return result;
    }
}