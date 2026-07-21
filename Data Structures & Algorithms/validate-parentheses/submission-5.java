class Solution {
    /*

    problem: the current closing bracket must match the most recent 
    unmatched opening bracket
    - Push opening brackets. 
    - On closing bracket, pop and check if the counterpart is on the top. 
        Return false on any mismatch or empty stack. 
    - Return stack.isEmpty() at end. 
    
    Time: O(n) — single pass of string
    Space: O(n) — stack stores n characters at max (e.g., "(((((")
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}