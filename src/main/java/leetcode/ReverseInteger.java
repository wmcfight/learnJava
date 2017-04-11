package leetcode;
/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        int symbol = x>=0?1:-1;
        x = x>=0?x:-x;
        int result = 0;
        while(x>0){
            result = result*10 + x%10;
            x/=10;
        }
        return result*symbol;
    }
}
