import org.junit.Test;

/*
数字反转 超出32位int则返回0
-123  -> -321
0     -> 0
123   -> 321
*/
public class LeetCode0007 {

    public int reverse(int x) {
        int result = 0, temp;
        boolean flag = false;
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) {
            x = -x;
            flag = true;
        }

        while (x > 0) {
            temp = x % 10;
            //反转后越界了
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                return 0;
            } else {
                result *= 10;
                result += temp;
            }
            x /= 10;
        }
        if (flag) result = -result;
        return result;
    }

    @Test
    public void mytest() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(1474836472));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
