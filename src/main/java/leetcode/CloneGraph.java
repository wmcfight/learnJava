package leetcode;

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };

    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == NULL) return NULL;
        map<UndirectedGraphNode*, UndirectedGraphNode*> copy;
        buildSubGraph(node, copy);
        return copy[node];
    }

    UndirectedGraphNode* buildSubGraph(UndirectedGraphNode* node, map<UndirectedGraphNode*, UndirectedGraphNode*>& copy){
        if(copy.find(node) != copy.end()) return copy[node];
        UndirectedGraphNode* new_node = new UndirectedGraphNode(node->label);
        copy[node] = new_node;
        for(int i=0;i<node->neighbors.size();i++){
            new_node->neighbors.push_back(buildSubGraph(node->neighbors[i],copy));
        }
        return new_node;
    }
 */

/**
 * copy a graph
 */

/*
用queue 加map 做层次拷贝

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 层次遍历，
 * 用map 防回路
 */


class UndirectedGraphNode {
    int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> copyMap = new HashMap<>();
        buildGraph(node, copyMap);
        return copyMap.get(node);
    }

    private UndirectedGraphNode buildGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> copyMap) {
        if (copyMap.containsKey(node)) {
            return copyMap.get(node);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        copyMap.put(node, newNode);
        for (UndirectedGraphNode curNode : node.neighbors) {
            newNode.neighbors.add(buildGraph(curNode, copyMap));
        }
        return newNode;
    }
}
