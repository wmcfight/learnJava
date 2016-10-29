package algorithm;

/**
 * Created by weimingchuan on 16/3/3.
 * 打印所有括号的排列组合,主要学习应用StringBuffer 替代String 的API
 *
 *
 *
 */
public class PrintSymbol {



    public static void printSymbol(int n, int left, StringBuffer s) {
        if (n%2 != 0) {
            return;
        }
        if (s.length() >= n) {


            System.out.println(s.toString());

            return;
        }

        if (left < n/2) {
            s.append('(');
            printSymbol(n, left + 1, s);
            s.deleteCharAt(s.length() - 1);
            if (left > s.length()/2) {
                s.append(')');
                printSymbol(n, left, s);
                s.deleteCharAt(s.length() - 1);
            }
        } else {
            s.append(')');
            printSymbol(n, left, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    // String 版本
    public static void printSymbol1(int n, int left, String s) {
        if (n % 2 != 0 ) {
            return;
        }
        if (s.length() >= n) {
            System.out.println(s);
            return;
        }

        if (left < n/2) {
            s += '(';
            printSymbol1(n, left + 1, s);
            // must use s.length() - 1
            if (left > (s.length() - 1)/2 ) {
                // 提出最后一个字符方法
                s = s.replaceAll(".$",")");
                printSymbol1(n, left, s);
            }
        } else {
            s += ')';
            printSymbol1(n, left, s);
        }
    }

    public static void main(String[] args) {
        //printSymbol(8, 0, new StringBuffer());
       printSymbol1(4, 0, new String());

    }
}
