package com.minhld.medium;

import java.util.Stack;

class MinStack {
    Stack<MinItem> stack;
    Integer currMinIndex = 0;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        this.stack.add(new MinItem(this.currMinIndex, value));
        if (value < this.stack.get(this.currMinIndex).value) this.currMinIndex = this.stack.size() - 1;
    }

    public void pop() {
        MinItem mi = this.stack.pop();
        this.currMinIndex = !this.stack.isEmpty() ? mi.prevMinIndex : 0;
    }

    public int top() {
        return this.stack.peek().value;
    }

    public int getMin() {
        return this.stack.get(this.currMinIndex).value;
    }

    class MinItem {
        int prevMinIndex;
        int value;

        public MinItem(int prevMinIndex, int value) {
            this.prevMinIndex = prevMinIndex;
            this.value = value;
        }
    }
}
