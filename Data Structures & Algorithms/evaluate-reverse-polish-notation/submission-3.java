class Solution {
    /*
    Iterate over the tokens
        1. push operands on stack
        2. when seeing operators, pop 2 operands from the stack
            do the operation: op1 +,-,*,/ op2
            push the result back on the stack
    Return the top of the stack
    Time: O(n)
    Space: O(n)
    */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String token = tokens[i];
            int op1;
            int op2;
            int result;
            switch(token){
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = op1 + op2;
                    stack.push(result);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = op1 - op2;
                    stack.push(result);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = op1 * op2;
                    stack.push(result);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = op1 / op2;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
