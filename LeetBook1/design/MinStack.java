package design;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = null, minstack = null;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.empty() || minstack.peek() >= val) {
            minstack.push(val);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minstack.peek()) {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
