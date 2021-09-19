package Arrays;

import org.junit.Test;

public class MoveZeroes {

    /**
     * 0ms 100
     * 38.4Mb 87.96
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    @Test
    public void mytest() {
        int[] nums = {1, 2, 2};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}