//Author: Tushar Jaiswal
//Creation Date: 08/05/2016

/*Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
Follow up: If this function is called many times, how would you optimize it?*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        List<Long> binaryNumbers = new ArrayList<Long>();
        
        long num = n;
        if(num < 0)
        {
            num = Integer.MAX_VALUE + Math.abs(num - Integer.MIN_VALUE) + 1;
        }
        
    
        do
        {
            binaryNumbers.add(num % 2);
            num = num/2;
        }while(num != 0);
        
        while(binaryNumbers.size() != 32)
        {
            binaryNumbers.add(0L);
        }
        
        long multiplier = (long)(Math.pow(2, binaryNumbers.size() - 1));
        
        n = 0;
        for(int i = 0; i < binaryNumbers.size(); i++)
        {
            n += binaryNumbers.get(i) * (multiplier);
            multiplier /= 2;
        }
        return n;
    }
}