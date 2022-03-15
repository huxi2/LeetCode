package Strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    // 有效的字母异位词若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int i, len = s.length();
        char c;
        //统计字符信息
        for (i = 0; i < len; i++) {
            c = s.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
            c = t.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }

        //判断字符数是否相等
        for (char item : map1.keySet()) {
            if (!map2.containsKey(item) || !map1.get(item).equals(map2.get(item)))
                return false;
        }
        return true;
    }

    @Test
    public void mytest() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

    }
}
