package Others;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) return true;
        Stack<Character> stack = new Stack<>();
        char c, t;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                t = stack.peek();
                if (t == '(' && c == ')' || t == '[' && c == ']' || t == '{' && c == '}') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return stack.empty();
    }
}
