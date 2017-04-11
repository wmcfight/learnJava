package leetcode;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > result,cur;
        if(num.size()<=0) return result;
        getPermute(num,0,result);
        return result;
    }
    void getPermute(vector<int>&num, int cur, vector<vector<int>>& data){
        if(cur>=num.size()){
            data.push_back(num);
            return ;
        }

        for(int i=cur;i<num.size();i++){
            swap(num[i],num[cur]);
            getPermute(num,cur+1,data);
            swap(num[i],num[cur]);
        }
    }

 */
public class Permutations {
}
