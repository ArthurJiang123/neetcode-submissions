class MinStack {
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
