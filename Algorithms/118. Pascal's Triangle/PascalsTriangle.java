//Author: Tushar Jaiswal
//Creation Date: 07/17/2016
/*Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      for(int i = 0; i < numRows; i++)
      {
          List<Integer> curr = new ArrayList<Integer>();
          for(int j = 0; j <= i; j++)
          {
              if(j == 0 || j == i)
              { curr.add(1); }
              else
              {
                  List<Integer> prev = result.get(i - 1);
                  curr.add(prev.get(j - 1) + prev.get(j));
              }
          }
          result.add(curr);
      }
      return result;
    }
}
