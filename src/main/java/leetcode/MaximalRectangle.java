package leetcode;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

int maximalRectangle(vector<vector<char> > &matrix) {
        if(matrix.size() <=0 || matrix[0].size() <=0) return 0;

        vector<int> data(matrix[0].size()+1,0);
        int result = 0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[i].size();j++){
                if(matrix[i][j] == '1'){
                    data[j] += 1;
                }else{
                    data[j] = 0;
                }
            }
            result = max(result,getMaxRectangle(data));
        }

        return result;

    }

    int getMaxRectangle(vector<int>&data){
        stack<int> dstack;
        int result = 0;
        for(int i=0;i<data.size();){
        	if(dstack.empty() || data[i] > data[dstack.top()]){
        		dstack.push(i++);
        	}else{
        		while(!dstack.empty() && data[i] <= data[dstack.top()]){
        			int w = data[dstack.top()];
					dstack.pop();
        			result = max(result,w * (dstack.empty() ? i : i-dstack.top() - 1));

        		}
        	}
        }

        return result;
    }
 */
public class MaximalRectangle {
}
