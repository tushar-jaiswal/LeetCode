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
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pQueue = new PriorityQueue<Element>();
        for(int col = 0; col < matrix[0].length; col++)
        { pQueue.offer(new Element(matrix[0][col], 0, col)); }
        for(; k > 1; k--)
        {
            Element e = pQueue.poll();
            if(e.x == matrix.length - 1)
            { continue; }
            pQueue.offer(new Element(matrix[e.x + 1][e.y], e.x + 1, e.y)); 
        }
        return pQueue.poll().val;
    }
}

class Element implements Comparable<Element>
{
    int val;
    int x;
    int y;
    
    public Element(int val, int x, int y)
    {
        this.val = val;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Element e)
    {
        return this.val - e.val;    
    }
}