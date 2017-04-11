package leetcode;

/*

 */
/**
 * 加减乘除用位运算，
 * http://www.cnblogs.com/kiven-code/archive/2012/09/15/2686922.html
 * 加法：
 * 一位二进制加法的真值表，可以看出和其实就是x XOR y的结果。而进位恰好是x AND y的结果。下面提供XOR和AND的真值表
 * 减法：
 * 转为加法
 * 乘法： 一种是循环
 *      高效版： 判断对应位是否是0，是直接移位
 *
 *  注意进位问题
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        long result = a;
        long carry = b;
        while (carry != 0) {
            long temp = result;
            result = temp ^ carry;
            carry = (temp & carry) << 1;
        }
        return (int)result;
    }

    public int add(int a, int b) {
        long result = a;
        long carry = b;
        while (carry != 0) {
            long temp = result;
            result = temp ^ carry;
            carry = (temp & carry) << 1;
        }
        return (int)result;
    }

    public int subtract(int a, int b) {
        int subtrahend = add(~b, 1);
        int sub = add(a, subtrahend);
        return sub;
    }


}
