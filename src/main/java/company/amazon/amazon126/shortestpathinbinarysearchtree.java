package company.amazon.amazon126;

/**
 * A node in a binary search tree always has a higher key at its right child compared to its left
 * child. There are many path running from the roots to the leaves. When we add up the key values along a path,
 * it will sum up to some number NUM1.
 * We need to find such a path where NUM1 is equal to K. Point worth noting is that,
 * we might have many paths summing up to K. We need to return the shortest of them all.
 * If there are multiple paths of the same length satisfying our condition then return any.
 */

/**
 * boolean findShortestPathToK(Node node,Stack stack,int sum,int currentSum){
 if(node == null){
 return false;
 }
 stack.push(node);
 currentSum +=node.data;
 if(currentSum > sum){
 stack.pop();
 return false;
 }
 if(currentSum == sum && node.right==null && node.left==null){
 return true;
 }
 if(findShortestPathToK(node.right, stack, sum, currentSum) || findShortestPathToK(node.left, stack, sum, currentSum)){
 return true;
 }
 stack.pop();
 return false;
 }

 */
/**
 solution:
 http://techieme.in/shortest-path-in-binary-search-tree/
 */
public class shortestpathinbinarysearchtree {
}
