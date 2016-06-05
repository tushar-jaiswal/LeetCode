//Author: Tushar Jaiswal
//Creation Date: 06/02/2016

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Note: Since the question wasn't clear or had additional examples to demonstrate whether there will be just 1 column of single characters or multiple, this solution is for multiple columns of single characters. So, it would work as shown for the following cases
convert("PAYPALISHIRING", 5) would return "PHASIYIRPLIGAN" 
P       H 
A     S I 
Y   I   R
P L     I G
A       N
and
convert("CANYOUSOLVETHISPROBLEM", 7) would return "CHATINESYVPMOLREUOOLSB".*/
public class Solution {
    public String convert(String s, int numRows) {
        String solution = "";
        if(s.length() < 3 || numRows == 1) {return s;}
        for (int i = 0; i < numRows; i++)
        {
            int j = i;
            int counter = 0;
            while(j < s.length())
            {
                solution += s.charAt(j);
                if(i == 0 || i == numRows-1)
                {
                    j += (numRows * 2) - 2;
                }
                else if(counter%2==0)
                {
                    j += ((numRows * 2) - (2 * (i+1)));
                }
                else
                {
                    j += ((numRows * 2) - 2) - ((numRows * 2) - (2 * (i+1)));
                }
                counter++;
            }
        }
        return solution;
    }
}