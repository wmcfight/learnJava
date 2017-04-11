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
public class MergeIntervals {
}
