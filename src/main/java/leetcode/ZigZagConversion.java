package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：
 * 用对应的list string 存储结果，用一个位置做记录，如果越界就反转
 *
 * 提升题目：如果告诉的是正序，怎么输出反序？
 * 待定
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuffer stringBuffer = new StringBuffer();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            data.add("");
        }

        int curAdd = 1;
        int curOrder = 0;
        for (int i = 0; i < s.length(); i++) {
            if (curOrder < 0) {
                curOrder = 1;
                curAdd = 1;
            } else if (curOrder > numRows - 1) {
                curOrder = numRows - 2;
                curAdd = -1;
            }
            data.set(curOrder, data.get(curOrder) + s.charAt(i));
            curOrder += curAdd;
        }
        for (int i = 0; i < numRows; i++) {
            stringBuffer.append(data.get(i));
        }
        return stringBuffer.toString();
    }

    public String revertCovert(String data, int numRows) {
        if (numRows <= 1) return data;
        StringBuffer stringBuffer = new StringBuffer();


        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion data = new ZigZagConversion();
        System.out.println(data.convert("PAYPALISHIRING", 3));
    }
}
