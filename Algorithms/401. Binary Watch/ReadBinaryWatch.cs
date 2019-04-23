//Author: Tushar Jaiswal
//Creation Date: 04/23/2019

/*A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".*/

public class Solution {
    public IList<string> ReadBinaryWatch(int num) {
        List<int> hourList = new List<int>{1, 2, 4, 8};
        List<int> minList = new List<int>{1, 2, 4, 8, 16, 32};
        List<string> times = new List<string>();
        if(num > 8)
        { return times; }

        for(int hourNum = Math.Min(num, 3), minNum = num - hourNum; hourNum >= 0 && minNum <= 5; hourNum--, minNum++)
        {
            List<string> hours = new List<string>();
            GetCombinations(hourNum, hourList, 0, hours, true);
            List<string> mins = new List<string>();
            GetCombinations(minNum, minList, 0, mins, false);
            foreach(string hour in hours)
            {
                foreach(string min in mins)
                {
                    times.Add(hour + ":" + min);
                }
            }
        }
        return times;
    }

    public void GetCombinations(int num, List<int> list, int total, List<string> result, bool isHours)
    {
        if(num == 0)
        {
            if((isHours && total < 12) || (!isHours && total >= 10 && total <= 59))
            {
                result.Add(total.ToString());
            }
            else if (!isHours && total < 10)
            {
                result.Add("0" + total.ToString());
            }
            return;
        }
        List<int> newList = new List<int>(list);
        int size = newList.Count;
        for(int i = 0; i < size; i++)
        {
            int item = newList[0];
            newList.RemoveAt(0);
            GetCombinations(num - 1, newList, total + item, result, isHours);
        }
    }
}
