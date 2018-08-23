//Author: Tushar Jaiswal
//Creation Date: 08/22/2018

/*There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.*/

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        HashMap<Integer, Integer> nodeTime = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < times.length; i++)
        {
            if(!graph.containsKey(times[i][0]))
            { graph.put(times[i][0], new ArrayList<int[]>()); }
            graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        heap.offer(new int[]{0, K});
        
        while(!heap.isEmpty())
        {
            int[] n = heap.poll();
            int time = n[0];
            int node = n[1];
            
            if(nodeTime.containsKey(node))
            { continue; }
            nodeTime.put(node, time);
            if(graph.containsKey(node))
            {
                for(int[] edge : graph.get(node))
                {
                    if(!nodeTime.containsKey(edge[0]))
                    { heap.offer(new int[]{time + edge[1], edge[0]}); }
                }
            }
        }
        
        if(nodeTime.size() != N)
        { return -1; }
        
        int maxTime = -1;
        for(int time : nodeTime.values())
        {
            if(time > maxTime)
            { maxTime = time; }
        }
        return maxTime;
    }
}