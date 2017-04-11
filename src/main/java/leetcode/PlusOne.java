package leetcode;

/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0){
                break;
            }
        }

        if(carry != 0){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }else{
            return digits;
        }
    }
}
