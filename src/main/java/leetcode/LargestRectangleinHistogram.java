package leetcode;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

int largestRectangleArea(vector<int> &height) {
        stack<int> dstack;
        height.push_back(0);
        int result = 0;
        for(int i=0;i<height.size();){
            if(dstack.empty() || height[i] > height[dstack.top()]){
                dstack.push(i++);
            }else{
                int tmp = dstack.top();
                dstack.pop();
                result = max(result,height[tmp] * (dstack.empty() ? i : i-dstack.top() - 1));
            }
        }
        return result;
    }

 */
public class LargestRectangleinHistogram {
}
