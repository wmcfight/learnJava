package leetcode;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> >result;
        vector<int> data;
        getSubVector(result,data,1,n,k);
        return result;
    }

private:
    void getSubVector(vector<vector<int> >&result,vector<int>&data,int start,int n,int k){
        if(data.size() == k){
            result.push_back(data);
            return;
        }

        for(int i=start;i<=n;++i){
            data.push_back(i);
            getSubVector(result,data,i+1,n,k);
            data.pop_back();
        }
    }
 */


public class Combinations {
}
