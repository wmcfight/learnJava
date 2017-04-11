package leetcode;

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
