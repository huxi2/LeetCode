package Arrays;

import org.junit.Test;

public class PlusOne {

    /**
     * 0ms 100%
     * 36.6Mb  90.8
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] result;
        // flag 初始等于1 相当于实现加一操作。并当做进位标志
        int i = digits.length - 1, flag = 1;
        //从个位依次进行计算
        while (i >= 0) {
            int temp = digits[i];
            if (temp + flag >= 10) {
                digits[i] = temp + flag - 10;
                flag = 1;
            } else {
                digits[i] = temp + flag;
                flag = 0;
            }
            i--;
        }
        result = new int[digits.length + flag];
        result[0] = flag;
        for (i = 0; i < digits.length; i++) {
            result[i + flag] = digits[i];
        }
        return result;
    }

    @Test
    public void mytest() {

    }
}