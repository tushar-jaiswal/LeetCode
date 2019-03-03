//Author: Tushar Jaiswal
//Creation Date: 03/03/2018

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true*/

using System;

namespace ConsoleApp
{
    class MeetingRooms
    {
        public static void Main(string[] args)
        {
            Interval[] intervals = new Interval[3];
            intervals[0] = new Interval(0, 30);
            intervals[1] = new Interval(0, 10);
            intervals[2] = new Interval(15, 20);

            Interval[] intervals2 = new Interval[2];
            intervals2[0] = new Interval(7, 10);
            intervals2[1] = new Interval(2, 4);

            Console.WriteLine("Person can attend intervals1 meetings:" + CanAttendMeetings(intervals));
            Console.WriteLine("Person can attend intervals2 meetings:" + CanAttendMeetings(intervals2));
        }

        private static bool CanAttendMeetings(Interval[] intervals)
        {
            Array.Sort(intervals, IntervalsComparer);

            for (int i = 1; i < intervals.Length; i++)
            {
                if (intervals[i].start < intervals[i - 1].end)
                {
                    return false;
                }
            }
            return true;
        }

        private static int IntervalsComparer(Interval i1, Interval i2)
        {
            return i1.start.CompareTo(i2.start);
        }
    }

    public class Interval
    {
        public int start;
        public int end;
        public Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }
    }
}
