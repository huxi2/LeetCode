package Others;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        int i = 0;
        for (; i < nums.length; i++) {
            flag[nums[i]] = true;
        }
        i = 0;
        while (flag[i]) i++;
        return i;
    }

    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int num : nums) {
            if (res == num) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
