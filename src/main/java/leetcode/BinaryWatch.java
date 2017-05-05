package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 暴力搜索,有个问题，不能所有分针加起来等于时针
 *
 * 还是http://blog.csdn.net/u013325815/article/details/52582210
 * 这个厉害，利用
 * 想到1,2,4,8都是2的整数倍，每个数都只有1个bit，那么就是搜索所有的解空间，
 * 看那几个数的bit之和等于num，不过谁能想到Integer有bitCount这个method呢？不过这个人确实牛逼！ %02d，0表示数字前面补0.
 */
public class BinaryWatch {
    private static final Integer[] MINUTES = {480, 240, 120, 60, 32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int num) {

        List<String> result = new ArrayList<>();
        if (num < 1 || num > MINUTES.length) {
            result.add("0:00");
            return result;
        }
        generate(num, 0, 0, 0, result);
        return result;
    }

    public List<String> readBinaryWatch2(int num) {

        List<String> result = new ArrayList<>();
        if (num < 0 ) return result;
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }

    private void generate(int num, int cur, int used, int curResult, List<String> result) {
        if (used >= num) {
            String curTime = convert(curResult);
            if (!curTime.isEmpty()) {
                result.add(convert(curResult));
            }

            return;
        }
        if (cur >= MINUTES.length) {
            return;
        }

        generate(num, cur + 1, used, curResult, result);

        curResult += MINUTES[cur];
        generate(num, cur + 1, used + 1, curResult, result);

    }

    private String convert(int minute) {
        int hour = minute/60;
        int min = minute%60;
        if (hour < 12) {
            return String.valueOf(hour + ":") + String.format("%02d", min);
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        System.out.println(binaryWatch.readBinaryWatch2(1));
    }


}
