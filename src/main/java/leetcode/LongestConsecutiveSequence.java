package leetcode;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.


 public int longestConsecutive(int[] num) {
        HashSet<Integer> dSet = new HashSet<Integer>();

        for(int i=0;i<num.length;i++){
            dSet.add(num[i]);
        }
        int result = 0;
        for(Integer item : num){
            if(dSet.contains(item)){
                dSet.remove(item);
                int count = 1;
                int cur = item;
                while(dSet.contains(++cur)){
                    count++;
                    dSet.remove(cur);
                }
                cur = item;
                while(dSet.contains(--cur)){
                    count++;
                    dSet.remove(cur);
                }
                result = Math.max(result,count);
            }
        }
        return result;
    }

 */
public class LongestConsecutiveSequence {
}
