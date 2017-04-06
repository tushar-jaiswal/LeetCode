//Author: Tushar Jaiswal
//Creation Date: 04/05/2017

/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.*/

/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        return BinarySearch(1,n);
    }
    
    public int BinarySearch(int start,int end)
    {
        if(start == end)
        {
            return start;
        }
        
        int middle = start + (end - start) / 2;
        if(IsBadVersion(middle))
        {
            return BinarySearch(start, middle);
        }
        else
        {
            return BinarySearch(middle + 1, end);
        }
    }
}