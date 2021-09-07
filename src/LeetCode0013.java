import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
罗马转整数
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
*/
public class LeetCode0013 {
    //解法1
    public int romanToInt(String s) {
        char pre = ' ';
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result += 1;
            } else if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                if (pre == 'I') result -= 2;
                if (s.charAt(i) == 'V') {
                    result += 5;
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                if (pre == 'X') result -= 20;
                if (s.charAt(i) == 'L') {
                    result += 50;
                } else {
                    result += 100;
                }
            } else {
                if (pre == 'C') result -= 200;
                if (s.charAt(i) == 'D') {
                    result += 500;
                } else {
                    result += 1000;
                }
            }
            pre = s.charAt(i);
        }
        return result;
    }

    //解法2
    public int romanToInt2(String s) {
        int result = 0;
        s = s.replace("IX", "a");
        s = s.replace("IV", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'a':
                    result += 4;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'b':
                    result += 9;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'c':
                    result += 40;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'd':
                    result += 90;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'e':
                    result += 400;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'f':
                    result += 900;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    @Test
    public void mytest() {
        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
    }
}

