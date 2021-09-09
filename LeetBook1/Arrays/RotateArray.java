package Arrays;

import org.junit.Test;

/**
 * 实现数组循环右移k位：
 */
public class RotateArray {
    /**
     * 实现start 到 end之间的数组/字符串反转  start 和 end 分别是两个下标指针
     * 0ms 100%
     * 55.3MB 37.73%
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    //通过数组原地转置实现
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    /**
     * 使用辅助数组实现
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * 当作一个环。使用双指针实现
     */
    public void rotate3(int[] nums, int k){
        int i,len = nums.length - k;
        for (i = 0; i < len; i++){
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            k %= len;
        }
    }

    @Test
    public void mytest() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++) {
            int[] temp = nums.clone();
            rotate2(temp, i);
            for (int j : temp) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}