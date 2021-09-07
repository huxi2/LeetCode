import org.junit.Test;

public class LeetCode0026 {
    //删除有序数组的重复元素
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {//若i和j位置不相等，i先加1，然后用j替换i
                i++;
                if (i != j) {//i和j不相邻则进行替换
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    @Test
    public void mytest() {
//        int nums[]={0,1,1,1,2,3,3};
        int[] nums = {0};
        System.out.println(nums.length);
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
