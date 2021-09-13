package Arrays;

import org.junit.Test;

import java.util.*;

public class ContainsDuplicate {

    /**
     * 使用map进行hash
     *  10ms
     *  44.2Mb
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        Map<Integer, Integer> myhash = new HashMap<>();
        int i, len = nums.length;
        for (i = 0; i < len; i++){
            if (myhash.containsKey(nums[i])){
                return true;
            }else{
                myhash.put(nums[i],1);
            }
        }
        return false;
    }

    /**
     * set 集合中不能含有相同的值。当多次添加相同的值时，会覆盖之前的值并返回false
     * @param nums
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length < 2) return false;
        Set<Integer> myset = new HashSet<>();
        for (int item : nums){
            if(!myset.add(item))
                return true;
        }
        return false;
    }

    /**
     * 先进行排序然后进行 查找，若相邻相等，则出现两次
     * 3ms
     */
    public boolean containsDuplicate3(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == nums[ i ])
                return true;
        }
        return false;
    }

    @Test
    public void mytest() {
        int[] nums = {1, 1};
        System.out.println(containsDuplicate3(nums));
    }
}