//Author: Tushar Jaiswal
//Creation Date: 08/16/2018

/*You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
Return: [1,2],[1,4],[1,6]
The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
Return: [1,1],[1,1]
The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 
Return: [1,3],[2,3]
All possible pairs are returned from the sequence: [1,3],[2,3]*/

public class Solution {
    public IList<int[]> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new List<int[]>();
        int m = nums1.Length, n = nums2.Length;
        if(m == 0 || n == 0)
        { return result; }
        SortedList<int, Tuple<int, int>> list = new SortedList<int, Tuple<int, int>>(new DuplicateKeyComparer());
        for(int j = 0; j < n; j++)
        { list.Add(nums1[0] + nums2[j], new Tuple<int, int>(0, j)); }
        for(int i = 0; i < Math.Min(k, m * n); i++)
        {
            int x = list.Values[0].Item1;
            int y = list.Values[0].Item2;
            list.RemoveAt(0);
            result.Add(new int[]{nums1[x], nums2[y]});
            if(x == m - 1)
            { continue; }
            list.Add(nums1[x + 1] + nums2[y], new Tuple<int, int>(x + 1, y));
        }
        return result;
    }
}

public class DuplicateKeyComparer : IComparer<int>
{
    public int Compare(int a, int b)
    {
        int result = a.CompareTo(b);
        return result == 0 ? 1 : result;
    }
}