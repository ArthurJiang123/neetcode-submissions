class MinStack {
    /*
    Use two stacks. Stack_1 holds all values normally. stack_2 tracks the minimum 
    at every step.
    - On push: Push the smaller of (new value, current top of stack_2).
    Push directly if stack_2 is empty. This ensures stack_2's top always has the 
    smallest value among all elements in the first stack.
    - On pop: pop from both stacks. stack_2's new top is the minimum of 
    the remaining elements in stack_1.

    Time: O(1) - constant stack-top access. | Space: O(n) - stores N elements
    */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.minStack.isEmpty()) this.minStack.push(val);
        else this.minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
