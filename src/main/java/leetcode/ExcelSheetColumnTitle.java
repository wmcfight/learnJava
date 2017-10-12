package leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        while (n > 0) {
            stringBuffer.append((char) ('A' + ((n - 1) % 26)));
            n = (n-1)/26;
        }
        return stringBuffer.reverse().toString();
    }

    public String convertToTitle2(int n) {
        String result = "";
        while (n > 0) {
            result = (char) ('A' + ((n - 1) % 26)) + result;
            n = (n-1)/26;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(29 % 26);
        ExcelSheetColumnTitle sample = new ExcelSheetColumnTitle();
        System.out.println(sample.convertToTitle2(26));
        System.out.println(sample.convertToTitle2(27));
        System.out.println(sample.convertToTitle2(29));
        System.out.println(sample.convertToTitle2(52));
    }
}
