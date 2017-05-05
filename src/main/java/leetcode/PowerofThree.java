package leetcode;

/**
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.


 */

/**
 * 升级版是log3(n) 为整数， 所以用log10(n) / log10(3)
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        while(n != 0 && n % 3 == 0) {
            n/=3;
        }
        return n == 1;
    }
}
