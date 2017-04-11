package leetcode;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

vector<vector<int> > subsetsWithDup(vector<int> &S) {
        vector<vector<int>> result;
        set<vector<int>> dSet;
        sort(S.begin(),S.end());
        int len = 1<<S.size();
        vector<int> temp;
        for(int i = 0;i<len;i++){
            for(int j=0;j<S.size();j++){
                if( i & 1<<j && i>=1<<j){
                    temp.push_back(S[j]);
                }
            }
            if(dSet.find(temp) == dSet.end()){
                result.push_back(temp);
                dSet.insert(temp);
            }
            temp.clear();

        }

        return result;
    }

 */
public class SubsetsII {
}
