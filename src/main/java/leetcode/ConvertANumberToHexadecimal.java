package leetcode;

public class ConvertANumberToHexadecimal {
    private static final Integer DIVIDEND = 16;
    public String toHex(int num) {
        long result  = num < 0 ? ~num : num;
        StringBuffer stringBuffer = new StringBuffer();
        while (result != 0) {
            stringBuffer.append(result % DIVIDEND);
            result /= DIVIDEND;
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal sample = new ConvertANumberToHexadecimal();
        //System.out.println(sample.toHex(26));
        System.out.println(sample.toHex(-1));

    }
}
