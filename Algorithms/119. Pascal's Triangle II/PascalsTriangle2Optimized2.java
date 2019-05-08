//Author: Tushar Jaiswal
//Creation Date: 05/07/2019

/*Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 3
Output: [1,3,3,1]

Follow up: Could you optimize your algorithm to use only O(k) extra space?*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++)
        {
            if(i == 0)
            {
                row.add(1);
            }
            int prev = 1;
            for(int j = 1; j <= i; j++)
            {
                if(i == j)
                {
                   row.add(1);
                }
                else
                {
                    int sum = prev + row.get(j);
                    prev = row.get(j);
                    row.set(j, sum);
                }
            }
        }
        return row;
    }
}
