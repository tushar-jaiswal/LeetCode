//Author: Tushar Jaiswal
//Creation Date: 09/25/2018

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

public class Solution {
    public void Solve(char[,] board) {
        int m = board.GetLength(0);
        int n = board.GetLength(1);
        
        Dictionary<Tuple<int, int>, bool> visited = new Dictionary<Tuple<int, int>, bool>();
        List<Tuple<int, int>> oList = new List<Tuple<int, int>>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i, j] == 'O')
                { 
                    visited.Add(new Tuple<int, int>(i, j), false); 
                    oList.Add(new Tuple<int, int>(i, j));
                }
            }
        }
        
        foreach(Tuple<int, int> element in oList)
        {
            if(visited[element] == false)
            {
                Queue<Tuple<int, int>> queue = new Queue<Tuple<int, int>>();
                queue.Enqueue(element);
                List<Tuple<int, int>> connectedOs = new List<Tuple<int, int>>();
                bool isSurrounded = true;
                while(queue.Count > 0)
                {
                    Tuple<int, int> point = queue.Dequeue();
                    if(visited[point])
                    { continue; }
                    visited[point] = true;
                    connectedOs.Add(point);
                    if(point.Item1 == 0 || point.Item2 == 0  || point.Item1 == m - 1  || point.Item2 == n - 1)
                    { isSurrounded = false; }
                    int[,] move = new int[,]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
                    for(int i = 0; i < move.GetLength(0); i++)
                    {
                        int x = point.Item1 + move[i, 0];
                        int y = point.Item2 + move[i, 1];
                        Tuple<int, int> newPoint = new Tuple<int, int>(x, y);
                        if(x >= 0 && y >= 0 && x < m && y < n && board[x, y] == 'O' && visited[newPoint] == false)
                        {
                            queue.Enqueue(newPoint);                            
                        }
                    }
                }
                if(isSurrounded)
                {
                    foreach(Tuple<int, int> tpl  in connectedOs)
                    {
                        board[tpl.Item1, tpl.Item2] = 'X';
                    }
                }
            }
        }
    }
}