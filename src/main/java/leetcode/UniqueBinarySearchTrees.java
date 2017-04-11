package leetcode;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


    int numTrees(int n) {
        int con[n+1];
        fill_n(con,n+1,0);
        con[0] = 1; con[1] = 1;
        for(int i=2;i<=n;++i){
            for(int j=0;j<i;++j){
                con[i] += con[j] * con[i-1-j];
            }
        }

        return con[n];

    }
 */


public class UniqueBinarySearchTrees {
}
