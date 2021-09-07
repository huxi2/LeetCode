import org.junit.Test;

public class LeetCode0020 {

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack[++top] = s.charAt(i);
            } else {
                if (top == -1 || s.charAt(i) == ')' && stack[top] != '(' ||
                        s.charAt(i) == ']' && stack[top] != '[' ||
                        s.charAt(i) == '}' && stack[top] != '{') return false;
                top--;
            }
        }
        if (top != -1) return false;
        return true;
    }

    @Test
    public void mytest() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid(")"));
    }
}
