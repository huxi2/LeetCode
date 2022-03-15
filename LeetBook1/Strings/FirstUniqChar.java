package Strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        //使用set记录已经判断过的字符
        Set<Character> set = new HashSet<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            //判度过
            if (set.contains(c)) continue;

            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(j) == c) {
                    //当第一次出现和最后一次出现的下标相等
                    if (i == j) {
                        return i;
                    }
                    break;
                }
            }
            set.add(c);
        }
        return -1;
    }

    @Test
    public void mytest() {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
