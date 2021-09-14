package Arrays;

import org.junit.Test;

public class SingleNumber {

    /**
     * 实现线性时间复杂度
     * 利用位操作，使用亦或，两次的就消除了，最后社工下的是一次的
     */
    public int singleNumber(int[] nums) {
        int res = nums[0], len = nums.length;
        for (int i = 1; i < len; i++){
            res = res ^ nums[i];
        }
        return res;
    }

    @Test
    public void mytest() {
        int[] nums = {1};
        System.out.println(singleNumber(nums));
    }
}
