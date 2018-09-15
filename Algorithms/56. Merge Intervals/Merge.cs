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
 *     public int start;
 *     public int end;
 *     public Interval() { start = 0; end = 0; }
 *     public Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public IList<Interval> Merge(IList<Interval> intervals) {
        SortedList<Interval, int> heap = new SortedList<Interval, int>(new IntervalComparer());
        foreach(Interval interval in intervals)
        { heap.Add(interval, 0); }
        List<Interval> result = new List<Interval>();
        if(heap.Count != 0)
        {
            Interval i1 = heap.Keys[0];
            heap.RemoveAt(0);
            while(heap.Count != 0)
            {
                Interval i2 = heap.Keys[0];
                heap.RemoveAt(0);
                if(i1.end >= i2.start)
                {
                    Interval merged = new Interval(i1.start, Math.Max(i1.end, i2.end));
                    i1 = merged;
                }
                else
                {
                    result.Add(i1);
                    i1 = i2;
                }
            }
            if(i1 != null)
            { result.Add(i1); }
        }
        return result;
    }
}

public class IntervalComparer: IComparer<Interval>
{
    public int Compare(Interval a, Interval b)
    {
        int result = a.start.CompareTo(b.start);
        return result == 0 ? 1 : result;
    }
}