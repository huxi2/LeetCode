package Strings;

import org.junit.Test;

public class MyAtoi {

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {
        boolean flag = false;
        int i = 0, res = 0, len = s.length();
        //去掉空格
        while (i < len && s.charAt(i) == ' ') i++;
        //符号判断
        if (i < len && !isNumber(s.charAt(i))) {
            if (s.charAt(i) == '-') {
                flag = true;
            } else if (s.charAt(i) != '+') {
                return 0;
            }
            i++;
        }

        // 直接判断数字
        while (i < len && isNumber(s.charAt(i))) {
            int temp = s.charAt(i++) - '0';
            //越界判断
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10) {
                if (flag) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            res *= 10;
            res += temp;
        }
        if (flag) res = -res;
        return res;
    }

    @Test
    public void mytest(){
        String s = "42";
        System.out.println(myAtoi(s));
    }
}
