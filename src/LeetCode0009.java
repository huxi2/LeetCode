import org.junit.Test;

/*
数字回文判断
-1   1-    false
0    0     true
121  121   true
213  312   false
*/
public class LeetCode0009 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x, res = 0;
        while (temp > 0) {
            if (res > Integer.MAX_VALUE / 10) return false;
            res *= 10;
            res += temp % 10;
            temp /= 10;
        }
        return res == x;
    }

    @Test
    public void mytest() {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-1));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
    }
}
