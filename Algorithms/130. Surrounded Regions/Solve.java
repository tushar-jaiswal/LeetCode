//Author: Tushar Jaiswal
//Creation Date: 09/26/2018

/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.*/

import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0)
        { return; }
        int n = board[0].length;
        
        HashMap<Map.Entry<Integer, Integer>, Boolean> visited = new HashMap<Map.Entry<Integer, Integer>, Boolean>();
        List<Map.Entry<Integer, Integer>> oList = new ArrayList<Map.Entry<Integer, Integer>>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O')
                { 
                    visited.put(new AbstractMap.SimpleEntry<Integer, Integer>(i, j), false); 
                    oList.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
                }
            }
        }
        
        for(Map.Entry<Integer, Integer> element : oList)
        {
            if(visited.get(element) == false)
            {
                Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<Map.Entry<Integer, Integer>>();
                queue.offer(element);
                List<Map.Entry<Integer, Integer>> connectedOs = new ArrayList<Map.Entry<Integer, Integer>>();
                boolean isSurrounded = true;
                while(!queue.isEmpty())
                {
                    Map.Entry<Integer, Integer> point = queue.poll();
                    if(visited.get(point))
                    { continue; }
                    visited.put(point, true);
                    connectedOs.add(point);
                    if(point.getKey() == 0 || point.getValue() == 0  || point.getKey() == m - 1  || point.getValue() == n - 1)
                    { isSurrounded = false; }
                    int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
                    for(int i = 0; i < move.length; i++)
                    {
                        int x = point.getKey() + move[i][0];
                        int y = point.getValue() + move[i][1];
                        Map.Entry<Integer, Integer> newPoint = new AbstractMap.SimpleEntry<Integer, Integer>(x, y);
                        if(x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'O' && visited.get(newPoint) == false)
                        {
                            queue.offer(newPoint);                            
                        }
                    }
                }
                if(isSurrounded)
                {
                    for(Map.Entry<Integer, Integer> entry  : connectedOs)
                    {
                        board[entry.getKey()][entry.getValue()] = 'X';
                    }
                }
            }
        }
    }
}