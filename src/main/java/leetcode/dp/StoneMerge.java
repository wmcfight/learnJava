package leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wmc on 2015/2/8.
 * it need two degree merge,
 * like min matrix merge
 */
public class StoneMerge {
     public int getMinMergeNumber(List<Integer> data) {
         if (data == null || data.size() <= 0) return -1;
         if (data.size() == 1) return data.get(0);
         int len = data.size();
         int[][]con = new int[len][len];

         for (int i = 0;i<len; i ++) {
             for (int j = 0; j < len; j++) {
                 if (i != j) {
                     con[i][j] = Integer.MAX_VALUE;
                 } else {
                     con[i][j] = data.get(i);
                 }
             }
         }

         for (int l = 1; l < len;l++) {
             for(int i = 0 ; i < len - l; i++) {
                 int j = i + l;   // most important code
                 for (int k = i; k < j; k++) {
                     con[i][j] = Math.min(con[i][j], con[i][k] + con[k+1][j]);
                 }
             }
         }
         return con[0][len-1];
     }

    public static void main(String[] args) {
        StoneMerge handler = new StoneMerge();
        Integer[] data = {5,3,4,5};
        System.out.println(handler.getMinMergeNumber(Arrays.asList(data)));
    }
}
