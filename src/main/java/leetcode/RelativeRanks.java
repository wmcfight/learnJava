package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class RankNode {
    int rank;
    int order;
}
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        if (nums.length <= 0) return new String[0];
        String[] result = new String[nums.length];
        RankNode[] nodes = new RankNode[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            RankNode temp = new RankNode();
            temp.order = i;
            temp.rank = nums[i];
            nodes[i] = temp;
        }

        // this type code
        Arrays.sort(nodes, (o1, o2) -> o1.rank < o2.rank ? 1 : -1);

        for (int i = 0; i < nodes.length; i++) {
            if (i < 3) {
                result[nodes[i].order] = (i == 0 ? "Gold Medal" : i == 1 ? "Silver Medal" : "Bronze Medal");
            } else {
                result[nodes[i].order] = String.valueOf(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {5,4,3,2,1};
        RelativeRanks sample = new RelativeRanks();
        sample.findRelativeRanks(data);
    }
}
