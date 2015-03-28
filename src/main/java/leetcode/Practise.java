package leetcode;


import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by wmc on 2015/1/16.
 */
public class Practise {
    public int findMax(List<Integer> data, int n) {
        if (data == null && data.size() <= 0) return -1;
        if (n <= 0) return -1;
        int len = data.size();
        int aLen = len % n == 0 ? len/n : len/n + 1;
        System.out.println("aLen " + aLen);
        int result = -1, maxLen = Integer.MIN_VALUE;
        int left = 0, right = data.size() - 1;
        int curLen = 1, cur, next;
        while (left <= right) {
            cur = data.get(left);
            if (left + aLen - 1<= right) {
                next = data.get(left + aLen - 1);
                if (cur == next) {
                    curLen = curLen + aLen - 1 ;
                    if (aLen == 1) {
                        left++;
                    } else {
                        left = left + aLen - 1;
                    }
                } else {
                    //
                    if (curLen >= aLen) {
                        //int location = getLocation(data, left, left + aLen, cur);
                        int location = Arrays.binarySearch(data.toArray(),left, left + aLen, cur);
                        curLen = curLen + location - left;
                        System.out.println("cur data " + cur + " cur len " + curLen);
                        if (curLen >= maxLen) {
                            result = cur;
                            maxLen = curLen;
                        }
                    }
                    // find next start
                    //left = getLocation(data,left,left+aLen,next);
                    left = Arrays.binarySearch(data.toArray(),left,left+aLen,next);
                    curLen = 1;
                }
            } else {
                break;
            }
        }
        return result;
    }

    public int getLocation(List<Integer> data, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data.get(mid) == target) {
                return mid;
            } else if (data.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Practise handle = new Practise();
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0;i < 12;i++) {
            data.add(new Random().nextInt(10));
        }
        Collections.sort(data);
        System.out.println(StringUtils.join(data,","));

        System.out.println(handle.findMax(data,10));
    }

}
