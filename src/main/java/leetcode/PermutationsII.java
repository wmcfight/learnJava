package leetcode;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
vector<vector<int> > permuteUnique(vector<int> &num) {
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
        set<int> used;
        for(int i=cur;i<num.size();i++){
            if(used.find(num[i]) != used.end()) continue;
            used.insert(num[i]);
            swap(num[i],num[cur]);
            getPermute(num,cur+1,data);
            swap(num[i],num[cur]);
        }
        used.clear();
    }
 */
public class PermutationsII {
}
