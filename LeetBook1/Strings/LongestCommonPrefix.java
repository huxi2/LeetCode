package Strings;

import org.junit.Test;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder(strs[0]);
        String s;
        for (int i = 1; i < strs.length; i++) {
            s = res.toString();
            res = new StringBuilder();
            int j = 0, k = 0, len1 = s.length(), len2 = strs[i].length();
            while (j < len1 && k < len2 && s.charAt(j) == strs[i].charAt(k)) {
                res.append(s.charAt(j));
                j++;
                k++;
            }
            if (res.length() == 0) break;
        }
        return res.toString();
    }

    @Test
    public void mytest() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
