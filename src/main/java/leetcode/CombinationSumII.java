package leetcode;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 the data must not be repeated
 */
/*
vector<vector<int> > combinationSum2(vector<int> &num, int target) {
         vector<vector<int> >result;
        vector<int> data;
        sort(num.begin(),num.end());
        //set<vector<int> > dSet;
        getSubSum(result,data,num,0,target);
        return result;
    }

    void getSubSum(vector<vector<int> >&result, vector<int>&data,vector<int>&num,int cur,int left){
        if(left == 0 ){
            result.push_back(data);
            return;
        }

        int prev = -1;
        for(int i=cur;i!=num.size();i++){
            if(prev == num[i]) continue;
        	if(left-num[cur]<0) return;
        	prev = num[i];
    		data.push_back(num[i]);
        	getSubSum(result,data,num,i+1,left-num[i]);
        	data.pop_back();

        }
    }
 */
public class CombinationSumII {
}
