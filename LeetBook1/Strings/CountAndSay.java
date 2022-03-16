package Strings;

import org.junit.Test;

public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        String s;
        int step = 1, count;
        char hold;
        // 开始处理
        while (step < n) {
            // 每次初始化
            s = res.toString();
            res = new StringBuilder();
            count = 0;
            hold = '.';
            for (int i = 0; i < s.length(); i++) {
                //出现新的字符
                if (s.charAt(i) != hold) {
                    //更新初始细腻些
                    if (count == 0) {
                        hold = s.charAt(i);
                        count++;
                    } else {
                        res.append(count);
                        res.append(hold);
                        count = 1;
                        hold = s.charAt(i);
                    }
                } else {
                    count++;
                }
            }
            if (count != 0) {
                res.append(count);
                res.append(hold);
            }
            step++;
        }
        return res.toString();
    }

    @Test
    public void mytest() {
        for (int i = 0; i < 5; i++) {
            System.out.println(countAndSay(i));
        }
    }

}
