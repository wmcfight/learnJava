package leetcode;

/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

vector<vector<int> > subsets(vector<int> &S) {
        vector<vector<int>> result;
        sort(S.begin(),S.end());
        int len = 1<<S.size();
        vector<int> temp;
        for(int i = 0;i<len;i++){

            for(int j=0;j<S.size();j++){
                if(i & 1<<j && i>= 1<<j)
                    temp.push_back(S[j]);
            }
            result.push_back(temp);
            temp.clear();
        }

        return result;
    }
 */
public class Subsets {
}
