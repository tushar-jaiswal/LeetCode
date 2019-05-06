//Author: Tushar Jaiswal
//Creation Date: 05/05/2019

/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class Solution {
    Dictionary<Tuple<int, int>, int> dict = new Dictionary<Tuple<int, int>, int>();

    public IList<IList<int>> Generate(int numRows) {
        List<IList<int>> result = new List<IList<int>>();
        for(int i = 0; i < numRows; i++)
        {
            List<int> row = new List<int>();
            for(int j = 0; j <= i; j++)
            {
                row.Add(GetPascals(i, j));
            }
            result.Add(row);
        }
        return result;
    }

    private int GetPascals(int i, int j)
    {
        if(j == 0 || i == j)
        { return 1; }
        Tuple<int, int> key = new Tuple<int, int>(i, j);
        if(!dict.ContainsKey(key))
        { dict[key] = GetPascals(i - 1, j - 1) + GetPascals(i - 1, j); }
        return dict[key];
    }
}
