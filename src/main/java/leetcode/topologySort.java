package leetcode;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by wmc on 2015/2/4.
 * Search for zero in degree
 * if exist circle, each node decrease 1 degree
 */
public class topologySort {

    private Map<Integer,Integer> nodeDegreeMap = new HashMap<Integer, Integer>();
    private List<Node> nodeList = new ArrayList<Node>();
    private Set<Integer> resultSet = new HashSet<Integer>();

    public void add(Node node) {
        if (node.from == node.to) return;
        nodeList.add(node);

        Integer degree = nodeDegreeMap.get(node.from);
        degree = degree == null ? 0 : degree;
        nodeDegreeMap.put(node.from,degree);

        degree = nodeDegreeMap.get(node.to);
        degree = degree == null ? 1 : degree + 1;
        nodeDegreeMap.put(node.to,degree + 1);

    }

    public List<Integer> sort() {
        if (nodeDegreeMap == null || nodeDegreeMap.size() <= 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        // make zero list
        Iterator iterator = nodeDegreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            if (entry.getValue() <= 0) {
                stack.push(entry.getKey());
                iterator.remove();
            }
        }


        while (!stack.empty()) {
            Integer curZero = stack.pop();
            if (!resultSet.contains(curZero)) {
                result.add(curZero);
                resultSet.add(curZero);
            }

            Iterator<Node> iterator1 = nodeList.iterator();
            while (iterator1.hasNext()) {
                Node curNode = iterator1.next();
                if (curNode.from == curZero) {
                    Integer curToDegree = nodeDegreeMap.get(curNode.to);
                    if (curToDegree == null || curToDegree <= 0) {
                        stack.push(curNode.to);
                        nodeDegreeMap.remove(curNode.to);
                    } else {
                        nodeDegreeMap.put(curNode.to, curToDegree - 1);
                    }
                    iterator1.remove();
                }
            }
        }

        if (nodeDegreeMap.size() > 0) {
            for (Map.Entry<Integer,Integer> entry : nodeDegreeMap.entrySet()) {
                nodeDegreeMap.put(entry.getKey(), entry.getValue() - 1);
            }
            result.addAll(sort());
        }


        return result;
    }

    static class Node {
        int from;
        int to;
        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        topologySort handler = new topologySort();
        handler.add(new Node(1,2));
        handler.add(new Node(1,3));
        handler.add(new Node(1,4));
        handler.add(new Node(1,5));
        handler.add(new Node(2,3));
        handler.add(new Node(2,4));
        handler.add(new Node(2,5));
        handler.add(new Node(3,5));
        handler.add(new Node(3,4));
        handler.add(new Node(4,5));
        handler.add(new Node(5,4));
        handler.add(new Node(5,3));
        List<Integer> result = handler.sort();
        System.out.println("Yes");
        System.out.println(StringUtils.join(result, ","));
    }
}
