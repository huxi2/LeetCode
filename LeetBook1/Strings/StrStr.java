package Strings;

import org.junit.Test;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        int len1 = haystack.length(), len2 = needle.length();
        if (len2 == 0) return 0;

        int i = 0, j = 0;
        //主串不回溯
        while (i < len1 && j < len2) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == len2 ? i - len2 : -1;
    }

    @Test
    public void mytest() {
        String s = "hello", t = "ll";
        System.out.println(strStr(s, t));

    }
}
