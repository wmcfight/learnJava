package leetcode;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

 vector<int> getRow(int rowIndex) {
        vector<int> result,temp;
        int cur = 0;
        while(cur <= rowIndex){
            for(int i=cur-1;i>0;i--){
                result[i] = result[i] + result[i-1];
            }
            result.push_back(1);
            cur++;

        }
        return result;
    }

 */
public class PascalsTriangle2 {
}
