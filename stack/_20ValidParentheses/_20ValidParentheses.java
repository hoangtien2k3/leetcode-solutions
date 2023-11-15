package stack._20ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                myStack.push(c);
            else {
                if (myStack.empty()) return false;
                char topStack = myStack.peek();
                if ((c == ')' && topStack == '(') || (c == '}' && topStack == '{') || (c == ']' && topStack == '[')) {
                    myStack.pop();
                } else return false;
            }
        }
        return myStack.empty();
    }
}

public class _20ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
