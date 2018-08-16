//Author: Tushar Jaiswal
//Creation Date: 08/15/2018

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
Note: You may assume k is always valid, 1 = k = n2.*/

public class Solution {
    public int KthSmallest(int[,] matrix, int k) {
        SortedList<int, Tuple<int, int>> list = new SortedList<int, Tuple<int, int>>(new DuplicateKeyComparer<int>());
        for(int col = 0; col < matrix.GetLength(1); col++)
        { list.Add(matrix[0,col], new Tuple<int, int>(0, col)); }
        for(; k > 1; k--)
        {
            int x = list.First().Value.Item1;
            int y = list.First().Value.Item2;
            list.RemoveAt(0);
            if(x == matrix.GetLength(0) - 1)
            { continue; }
            list.Add(matrix[x + 1, y], new Tuple<int, int>(x + 1, y));
        }
        return list.First().Key;
    }
}

public class DuplicateKeyComparer<TKey> : IComparer<TKey> where TKey : IComparable
{
    public int Compare(TKey a, TKey b)
    {
        int result = a.CompareTo(b);
        return result == 0 ? 1 : result;
    }
}