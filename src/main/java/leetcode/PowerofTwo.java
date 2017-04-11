package leetcode;

/*
Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0 ) return false;
        while (n % 2 == 0) {
            n/=2;
        }

        return n == 1;
    }
}
