package leetcode;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

vector<vector<int> > generate(int numRows) {
        vector<vector<int> > result;
        int cur = 1;
        vector<int> temp;
        while(cur<=numRows){
        	if(cur == 1) result.push_back(vector<int>(1,1));
        	else
			{
        		temp.clear();
        		temp.push_back(1);
            	for(int i=1;i<cur-1;i++){
                 	temp.push_back(result[cur-2][i-1]+result[cur-2][i]);
            	}
            	temp.push_back(1);
            	result.push_back(temp);
        	}
            cur++;
        }


        return result;
    }
 */
public class PascalsTriangle {
}
