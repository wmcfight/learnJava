package leetcode;

import java.util.Stack;

/**
 * calculate A ^ B
 */

/**
 * A ^ B = A ^ (1100)Binary
 */
public class APowerOfB {
    public Double calculatePower(Integer A, Integer B) {
        Double result = 1.0;

        Stack<Integer> binRes = getBinaryData(B);
        while(!binRes.empty()) {
            Integer cur = binRes.pop();
            if (cur == 1) {
                result = result * result * A;
            } else {
                result = result * result;
            }
        }
        return B > 0 ? result : 1/result;
    }

    private Stack<Integer> getBinaryData(Integer B) {
        Integer data = Math.abs(B);
        Stack<Integer> res = new Stack<>();
        if (data == 0) {
            res.push(0);
        }
        else {
            while(data > 0) {
                res.push(data%2);
                data /= 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        APowerOfB sample = new APowerOfB();
        System.out.println(sample.calculatePower(3, 3));
        System.out.println(sample.calculatePower(-3, 3));
        System.out.println(sample.calculatePower(3, -3));
    }


}
