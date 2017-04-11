package leetcode;

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        vector<vector<int> >result;
        vector<int> data;
        sort(candidates.begin(),candidates.end());
        getSubSum(result,data,candidates,0,target);
        return result;
    }

    void getSubSum(vector<vector<int> >&result, vector<int>&data,vector<int>&candidates,int cur,int left){
        if(left == 0){
            result.push_back(data);
            return;
        }


        for(int i=cur;i!=candidates.size();i++){
        	if(left-candidates[cur]<0) return;
    		data.push_back(candidates[i]);
        	getSubSum(result,data,candidates,i,left-candidates[i]);
        	data.pop_back();

        }

    }
 */
public class CombinationSum {

}
