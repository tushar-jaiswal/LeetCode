//Author: Tushar Jaiswal
//Creation Date: 03/02/2019

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true*/

import java.util.*;

public class MeetingRooms {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);

		Interval[] intervals2 = new Interval[2];
		intervals2[0] = new Interval(7, 10);
		intervals2[1] = new Interval(2, 4);

		System.out.println("Person can attend intervals1 meetings:" + canAttendMeetings(intervals));
		System.out.println("Person can attend intervals2 meetings:" + canAttendMeetings(intervals2));
	}

	public static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		for(int i = 1; i < intervals.length; i++)
		{
			if(intervals[i].start < intervals[i - 1].end)
			{
				return false;
			}
		}

		return true;
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
