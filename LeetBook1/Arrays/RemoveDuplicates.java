package Arrays;

import org.junit.Test;

/**
 * 原地删除数组的重复选项
 */
public class RemoveDuplicates {

    /**
     * 双指针实现删除
     * 1ms 96.01%
     * 39.9mb 50.18%
     */
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void mytest() {
        int[] nums = {0, 0, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}