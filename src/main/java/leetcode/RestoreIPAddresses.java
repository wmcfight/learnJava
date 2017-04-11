package leetcode;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        string data;
        int len =0, cur = 0;
        getSubIp(result,s,len,cur,data,0,false);
        return result;
    }

    void getSubIp(vector<string>&result,string& s,int len,int cur, string&data,int num,bool isnumber){
       //printf("len is %d , cur is %d , data is %s \n",len,cur,data.c_str());
	    if(len==3 && cur == s.size()){
            //data.erase(data.size() - 1);
            result.push_back(data);
            return;
        }
        if(len >3 || cur>=s.size()) return;

		if(num * 10 + s[cur] - '0' <= 255){
            if(isnumber && num == 0) {
            }else{
            	data.push_back(s[cur]);
            	getSubIp(result,s,len,cur+1,data,num*10+s[cur]-'0',true);
            	data.erase(data.size() - 1);
            }
        }

        if(isnumber){
             data.push_back('.');
             getSubIp(result,s,len+1,cur,data,0,false);
             data.erase(data.size() - 1);
        }

    }
 */
public class RestoreIPAddresses {
}
