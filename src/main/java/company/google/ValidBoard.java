package company.google;


/**
 * Created by wmc on 2015/2/13.
 * 挺伤心和白痴的，居然一下子没有反应过来，
 * 太依赖模板啦，哎
 * 思维还是太僵化，
 * 这题有两次解法，
 * 一种就是简单的dp,O(n)
 * 一种是dfs，O(2^n)
 */
public class ValidBoard {


    public static void main(String[] args) {
        int n = 3;
        System.out.println("Get data " + getSolution1(3));
        System.out.println("Get data1 " + dfsSolution(3));

        System.out.println("Get data " + getSolution1(5));
        System.out.println("Get data1 " + dfsSolution(5));
    }


     // dp
    static int getSolution1(int n) {
        if (n <= 2) return 2 * n > 0 ? 2 * n : 0;
        int f2 = 1, f1 = 1;
        int sum = 0;
        for (int i = 2; i< n; i++) {
            int tf1 = f2 + f1;
            int tf2 = f1;
            sum = tf1 + tf2;
            f1 = tf1;
            f2 = tf2;
        }
        return sum * 2;
    }

    static int dfsSolution(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 2 * n;
        return dfsHelper(true, true, n -2) + dfsHelper(true,false,n-2)
               + dfsHelper(false,true,n-2) + dfsHelper(false,false,n-2);
    }

    static int dfsHelper(boolean last, boolean secLast, int n) {
        if (n<=0) return 1;
        int result = 0;
        if (last != true || secLast != true) {
            result += dfsHelper(secLast, true, n-1);
        }
        if (last != false || secLast != false) {
            result += dfsHelper(secLast, false, n-1);
        }
        return result;
    }


}
