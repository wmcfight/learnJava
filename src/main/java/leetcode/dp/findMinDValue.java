package leetcode.dp;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by wmc on 2015/2/8.
 * give a array number, please divide them into two array,
 * and make sure them d value is min
 * solution: it is a 01 bag leetcode.dp problem
 */
public class findMinDValue {

    public Integer findTotalMinD(List<Integer> data) {
        if (data == null || data.size() <=0) return -1;

        List<Integer> result = new ArrayList<Integer>();
        // find total Sum
        int total = 0;
        for (Integer cur : data) {
            total += cur;
        }

        total = total /2;
        int len = data.size();
        int[] con = new int[total+1];
        Arrays.fill(con, 0);


        for (int i = 0; i < len; i++) {

            for (int v = 0; v <=total ; v++) {
                if (v >= data.get(i)) {
                    if (con[v] > con[v - data.get(i)] + data.get(i)) {
                        con[v] = con[v];
                        // not set
                    } else {
                        con[v] = con[v - data.get(i)] + data.get(i);
                    }
                }
            }
        }

        int maxL = 0,maxV = Integer.MIN_VALUE;
        for (int i = 0; i < con.length; i++) {
            if (con[i] > maxV) {
                maxV = con[i];
                maxL = i;
            }
        }



        return maxV;

    }

    public Collection<Integer> find01MinD(List<Integer> data) {
        if (data == null || data.size() <=0) return Collections.emptyList();

        List<Integer> result = new ArrayList<Integer>();
        // find total Sum
        int total = 0;
        for (Integer cur : data) {
            total += cur;
        }

        total = total /2;
        int len = data.size();
        int[] con = new int[total+1];
        Map<Integer, Set<Integer>> conMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0 ; i <= total; i++) {
            conMap.put(i,new HashSet<Integer>());
        }
        Arrays.fill(con, 0);


        for (int i = 0; i < len; i++) {

            for (int v = total; v >=0 ; v--) {
                int cost = data.get(i), weight = data.get(i);

                if (v >= data.get(i)) {
                    if (con[v] > con[v - data.get(i)] + data.get(i)) {
                        con[v] = con[v];
                        // not set
                    } else {
                        con[v] = con[v - data.get(i)] + data.get(i);
                        conMap.get(v).clear();
                        conMap.get(v).addAll(conMap.get(v - data.get(i)));
                        conMap.get(v).add(data.get(i));
                    }
                }
            }
        }

        int maxL = 0,maxV = Integer.MIN_VALUE;
        for (int i = 0; i < con.length; i++) {
            if (con[i] > maxV) {
                maxV = con[i];
                maxL = i;
            }
        }



        return conMap.get(maxL);

    }

    public static void main(String[] args) {
        findMinDValue handle = new findMinDValue();
        Integer[] dataArray = {1,101};
        Collection<Integer> result = handle.find01MinD(Arrays.asList(dataArray));
        Integer result2 = handle.findTotalMinD(Arrays.asList(dataArray));
        System.out.println("01 result " +StringUtils.join(result,","));
        System.out.println("Total result " + result2);
    }
}
