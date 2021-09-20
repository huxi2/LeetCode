package Arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    /**
     * 哈希解决
     * 2ms 87.9
     * 38.6Mb 56.5
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mymap = new HashMap<>();
        int i = 0;
        for (; i < nums.length; i++) {
            if (mymap.containsKey(nums[i])) {
                result[0] = mymap.get(nums[i]);
                result[1] = i;
                break;
            } else {
                // target = a+b
                //hashmap的 key = b， value 是 a 的下标
                mymap.put(target - nums[i], i);
            }
        }
        return result;
    }

    /**
     * 双指针
     * 50ms 34.72
     * 38.6Mb  48.47
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int i, j;
        for (i = 0; i < nums.length - 1; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void mytest() {
        int[] nums = {2, 7, 11, 15}, result;
        int target = 13;
        result = twoSum2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}