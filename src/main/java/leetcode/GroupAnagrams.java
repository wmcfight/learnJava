package leetcode;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

public:
    vector<string> anagrams(vector<string> &strs) {
        map<string,vector<string> >result;
        for(int i=0;i<strs.size();++i){
            result[getNewString(strs[i])].push_back(strs[i]);
        }

        vector<string> empty;
        map<string,vector<string> >::iterator iter = result.begin();
        while(iter != result.end()){
        	//printf("key is %s ,data size is %d\n",iter->first.c_str(),iter->second.size());
            if(iter->second.size() > 1)
                empty.insert(empty.end(),iter->second.begin(),iter->second.end());
            iter++;
        }

        return empty;
    }
private:
    string getNewString(const string& data){
        if(data.size()<=1) return data;
        string temp = data;
        int index = 0;
        for(int i=0;i<temp.size();++i){
            if(isalpha(temp[i])){
                temp[index++] = temp[i];
            }
        }
        //printf("get new data is %s \n",temp.substr(0,index).c_str());
        temp = temp.substr(0,index);
        sort(temp.begin(),temp.end());
        return temp;
    }

 */
public class GroupAnagrams {
}
