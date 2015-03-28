package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wmc on 2015/2/8.
 */
public class FibStr {

    private static int nth = 2;
    private static Map<Integer,String> dMap = new HashMap<Integer, String>();
    boolean check(String data, char c1, char c2) {
        int c2n = 0;
        if (data == null || data.length() <= 0) return false;
        for (int i =0; i < data.length(); i++) {
            if (data.charAt(i) != c1 && data.charAt(i) != c2) {
                return false;
            }
            if (data.charAt(i) == c1) {
                c2 = 0;
                if (i < 1 || (i >=1 && data.charAt(i-1) == c2)) {
                  continue;
                } else {
                    return false;
                }
            } else {
                if (i < 1 || (i >= 1 && data.charAt(i) == c1)) {
                    c2n = 1;
                } else {
                    c2n++;
                    if (c2n > 2) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    int findSubstr(String subStr, String comStr) {
        if (subStr == null || comStr == null) return 0;
        if (subStr.length() < comStr.length()) return 0;
        int len1 = subStr.length(), len2 = comStr.length();
        int sum = 0;
        for (int i = 0; i <= len1 - len2; i++ ) {
            if (subStr.substring(i,i+len2).equals(comStr)) {
                sum++;
            }
        }
        return sum;
    }

    String findNth(char c1, char c2, String comStr, int order) {
        int len = comStr.length();
        if (len == 1) {
            nth = 1;
            return order == 1 ? String.valueOf(c1) : String.valueOf(c2);
        }

        int curLen = 2;
        String  data1 = String.valueOf(c2), data0 = String.valueOf(c1),data2 = data1+data0;
        nth++;
        while(data2.length() < len) {
            nth++;
            data0 = data1;
            data1 = data2;
            data2 = data1+data0;
        }

        return order == 1 ? data2 : data2+data1;
    }

    String findNthStr(char c1, char c2, int order) {
        if (order < 1) return null;
        if (order == 1) return String.valueOf(c1);
        if (order == 2) return String.valueOf(c2);
        String n1 = dMap.get(order-1);
        if (n1 == null) {
            n1 = findNthStr(c1,c2,order-1);
            dMap.put(order-1,n1);
        }
        String n2 = dMap.get(order-2);
        if (n2 == null) {
            n2 = findNthStr(c1,c2,order-2);
            dMap.put(order-2,n2);
        }

        return new StringBuffer().append(n1).append(n2).toString();
    }

    int findExistNum(int N, char c1, char c2, String comStr) {
        //if (!check(comStr,c1,c2)) return 0;
        String n1Str = findNth(c1, c2, comStr,1);

        int curn1 = findSubstr(n1Str, comStr);
        return findG(N,c1,c2,comStr,curn1);
    }

    int findSubNumber(int N, char c1, char c2, String comStr) {
        if (N > nth + 1) {
            return findSubNumber(N - 2, c1, c2, comStr);
        } else {
            String data1 = findNthStr(c1,c2,N - 1);
            String data2 = findNthStr(c1,c2,N - 2);
            if (data1 == null || data2 == null || data1.length() < 1 || data2.length() < 1) return 0;
            int l1 = data1.length() < comStr.length() ? data1.length() - 1 : data1.length() - comStr.length() + 1;
            int l2 = data2.length() < comStr.length() ? data2.length()  : comStr.length() - 1;
            String subStr = data1.substring(l1,data1.length()) +
                    data2.substring(0,l2);
            System.out.println("N is " + N + " data is " + subStr);
            return findSubstr(subStr,comStr);
        }
    }


    int findG(int N, char c1, char c2, String comStr, int addCom) {
        if (N < nth) return 0;
        if (N == nth) return addCom;
        return findG(N-1,c1,c2,comStr,addCom) + findG(N-2,c1,c2,comStr,addCom) + findSubNumber(N,c1,c2,comStr);
    }

    List<Integer> getData() {
       return Collections.emptyList();
    }

    public static void main(String[] args) {
        FibStr handler = new FibStr();
        char c1 = 'a', c2 = 'b';
        System.out.println(handler.findExistNum(7, c1, c2, "ab"));
    }

    
}
