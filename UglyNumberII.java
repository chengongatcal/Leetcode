/** 264. Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
*/

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        if(n <= 6){
            return n;
        }
        ugly[0] = 1;
        int two = 0, three = 0, five = 0;
        for(int i = 1; i < n; i++){
            int min = Math.min(ugly[two]*2, Math.min(ugly[three]*3, ugly[five]*5));
            if(ugly[two]*2 == min){
                ugly[i] = ugly[two] * 2;
                two++;
            }
            if(ugly[three]*3 == min){
                ugly[i] = ugly[three] * 3;
                three++;
            }
            if(ugly[five]*5 == min){
                ugly[i] = ugly[five]*5;
                five++;
            }
        }
        return ugly[n-1];
    }
}