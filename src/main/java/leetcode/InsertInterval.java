package leetcode;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 */

import java.util.ArrayList;
import java.util.ListIterator;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //ArrayList<Interval> res = new ArrayList<Inteval>();
        int sz = intervals.size();

        int low = newInterval.start;
        int high = newInterval.end;

        ListIterator<Interval> iter = intervals.listIterator();

        while(iter.hasNext() ) {
            Interval it =  iter.next();

            if(high<it.start) {
                iter.previous();
                iter.add( new Interval(low, high) );
                return intervals;
            }


            if(low>it.end) {
                continue;
            } else {
                low = Math.min(low, it.start);
                high = Math.max(high, it.end);
                iter.remove();
            }
        }

        intervals.add(new Interval(low, high) );
        return intervals;
    }
}
