package leetcode;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.


public:
vector<vector<string> > findLadders(string start, string end,
const unordered_set<string> &dict) {
unordered_set<string> current, next; // 当前层，下一层，用集合是为了去重
unordered_set<string> visited; // 判重
unordered_map<string, vector<string> > father; // 树
bool found = false;
auto state_is_target = [&](const string &s) {return s == end;};
auto state_extend = [&](const string &s) {
unordered_set<string> result;
for (size_t i = 0; i < s.size(); ++i) {
string new_word(s);
for (char c = 'a'; c <= 'z'; c++) {
if (c == new_word[i]) continue;
swap(c, new_word[i]);
if ((dict.count(new_word) > 0|| new_word == end) &&
!visited.count(new_word)) {
result.insert(new_word);
}
swap(c, new_word[i]); // 恢复该单词
}
}
return result;
};
current.insert(start);
while (!current.empty() && !found) {
// 先将本层全部置为已访问，防止同层之间互相指向
for (const auto& word : current)
visited.insert(word);
for (const auto& word : current) {
const auto new_states = state_extend(word);
for (const auto &state : new_states) {
if (state_is_target(state)) found = true;
next.insert(state);
father[state].push_back(word);
// visited.insert(state); // 移动到最上面了
}
}
current.clear();
swap(current, next);
}
vector<vector<string> > result;
if (found) {
vector<string> path;
gen_path(father, path, start, end, result);
}
return result;
}
private:
void gen_path(unordered_map<string, vector<string> > &father,
vector<string> &path, const string &start, const string &word,
vector<vector<string> > &result) {
path.push_back(word);
if (word == start) {
result.push_back(path);
reverse(result.back().begin(), result.back().end());
} else {
for (const auto& f : father[word]) {
gen_path(father, path, start, f, result);
}
}
path.pop_back();
}
 */
public class WordLadderII {
}
