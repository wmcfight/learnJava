package leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 * 解题思路：
 * 注意java stack API 的使用！！！！
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minDStack;

    public MinStack() {
        dataStack = new Stack<>();
        minDStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (!minDStack.empty()) {
            //KEY POINT
            if (x <= minDStack.peek()) {
                minDStack.push(x);
            }
        } else {
            minDStack.push(x);
        }
    }

    public void pop() {
        if (!dataStack.empty()) {
            Integer data = dataStack.pop();
            if (data <= minDStack.peek()) {
                minDStack.pop();
            }
        }
    }

    public int top() {
        return dataStack.empty() ? 0 : dataStack.peek();
    }

    public int getMin() {
        return minDStack.empty() ? 0 : minDStack.peek();
    }
}
