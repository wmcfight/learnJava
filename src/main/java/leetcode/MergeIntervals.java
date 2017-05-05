package leetcode;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

vector<Interval> merge(vector<Interval> &intervals) {
        vector<Interval> result;
        vector<Interval>::iterator iter = intervals.begin(),jter;
        int low,high;
        bool find = true;
        while(iter != intervals.end()){
            low = iter->start;
            high = iter->end;
            jter = result.begin();
            find = false;
            while(jter != result.end()){
                if(high < jter->start){
                    result.insert(jter,Interval(low,high));
                    find = true;
                    break;
                }else if(low > jter->end){
                    jter++;
                    continue;
                }else{
                    low = min(low,jter->start);
                    high = max(high,jter->end);
                    jter = result.erase(jter);
                }
            }
            if(!find){
                result.insert(result.end(),Interval(low,high));
            }
            iter++;
        }

        return result;
    }

 */

/**
 * 题意：有很多个区间，把有重叠的区间合并。

 思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() <= 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int curStart = intervals.get(0).start;
        int curEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > curEnd) {
                result.add(new Interval(curStart, curEnd));
                curStart = interval.start;
                curEnd = interval.end;
            } else {
                curEnd = Math.max(curEnd, interval.end);
            }
        }

        result.add(new Interval(curStart, curEnd));
        return result;
    }
}
