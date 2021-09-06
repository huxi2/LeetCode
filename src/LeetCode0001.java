import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0001 {
    /*
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

    入：nums = [2,7,11,15], target = 9
    出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    */
    // 时间复杂度O(n2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    // 时间复杂度O(n)  创建key-value   key 当作差,value为下标
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 存在某个数和当前值和为target
            if (!map.isEmpty() && map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                //当前数字无法匹配时，将差值和所在位置存到map中
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void mytest() {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        LeetCode0001 l = new LeetCode0001();
        int result[] = l.twoSum2(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
