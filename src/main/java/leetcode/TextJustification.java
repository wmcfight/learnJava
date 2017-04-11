package leetcode;

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

 vector<string> fullJustify(vector<string> &words, int L) {
        int i=0,total = 0;
        vector<string> temp,result;
        vector<pair<int,vector<string> > > data;
        while(i<words.size()){
            if(words[i].size() + total + temp.size() <= L){
                temp.push_back(words[i]);
                total += words[i].size();
                i++;
            }else{
                data.push_back(make_pair(total,temp));
                temp.clear();
                total = 0;
            }
        }
        if(!temp.empty()){
            data.push_back(make_pair(total,temp));
        }

        result = getStrings(data,L);
        return result;
    }

    vector<string> getStrings(vector<pair<int,vector<string> > >& data,int L){
        stringstream stemp;
        int len,ave,aleft,left;
        vector<string> result;
        for(int i=0;i<data.size()-1;i++){
            stemp.str("");     //clear the stringstream
            left = L - data[i].first;
            if(data[i].second.size() == 1){
                stemp<<data[i].second[0];
                for(int j=0;j<left;j++){
                    stemp<<" ";
                }
            }else{
                len = data[i].second.size() - 1;
                ave = left/len;
                aleft = left - ave * len;
                for(int j=0;j<data[i].second.size()-1;j++){
                    stemp<<data[i].second[j];
                    for(int k=0;k<ave;k++){
                        stemp<<" ";
                    }
                    if(aleft>0){
                        stemp<<" ";
                        aleft--;
                    }
                }
                stemp<<data[i].second[data[i].second.size()-1];
            }
            result.push_back(stemp.str());
        }

        //for the last one
        stemp.str("");
        left = L,aleft = data[data.size()-1].second.size()-1;
        for(int i=0;i<data[data.size()-1].second.size();i++){
            stemp<<data[data.size()-1].second[i];
            left -= data[data.size()-1].second[i].size();
            if(aleft > 0){
                stemp<<" ";
                left--;
                aleft--;
            }
        }
        for(int i=0;i<left;i++){
            stemp<<" ";
        }
        result.push_back(stemp.str());
        return result;

    }


 */
public class TextJustification {
}
