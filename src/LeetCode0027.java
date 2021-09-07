import org.junit.Test;

public class LeetCode0027 {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    @Test
    public void mytest() {
        int[] nums = {0, 1, 1, 1, 2, 3, 3};
        int val = 0;
        int res = removeElement(nums, val);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
