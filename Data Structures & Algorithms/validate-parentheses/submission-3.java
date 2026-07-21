class Solution {
    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' | c == '{'| c == '['){
                stack.push(c);
            } else if(!isValid(c)){
                return false;
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isValid(char c){
        if(stack.isEmpty()) return false;
        if (c == ')') c = '(';
        else if (c == '}') c = '{';
        else if (c == ']') c = '[';

        if(stack.pop() != c) return false;

        return true;
    }
}
