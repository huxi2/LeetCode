import org.junit.Test;

public class LeetCode0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuffer res = new StringBuffer();
        res.append(strs[0]);
        //最长串不为空，并且strs中还有可比较的串
        for (int i = 1; i < strs.length && res.length() > 0; i++) {
            //res和strs[i]挨个比较中第j个元素。 并且j要小于strs[i]的长度
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (res.charAt(j) == strs[i].charAt(j)) {
                    continue;
                } else {
                    res = res.delete(j, res.length());
                }
            }
            //如果当前最长串res长度大于strs[i]的长度并且完全匹配的情况下
            if (j == strs[i].length() && j < res.length()) {
                res = res.delete(j, res.length());
            }
        }
        return res.toString();
    }

    @Test
    public void mytest() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
    }
}
