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

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        int m = nums1.length, n = nums2.length;
        if(m == 0 || n == 0)
        { return result; }            
        PriorityQueue<Element> pQueue = new PriorityQueue<Element>();
        for(int j = 0; j < nums2.length; j++)
        { pQueue.offer(new Element(nums1[0] + nums2[j], 0, j)); }
        for(int i = 0; i < Math.min(k, m * n); i++)
        {
            Element e = pQueue.poll();
            result.add(new int[]{nums1[e.x], nums2[e.y]});
            if(e.x == nums1.length - 1)
            { continue; }
            pQueue.offer(new Element(nums1[e.x + 1] + nums2[e.y], e.x + 1, e.y)); 
        }
        return result;
    }
}

class Element implements Comparable<Element>
{
    int sum;
    int x;
    int y;
    
    public Element(int sum, int x, int y)
    {
        this.sum = sum;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Element e)
    {
        return this.sum - e.sum;    
    }
}