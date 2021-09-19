package Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {

    /**
     * 先对数组排序，然后使用双指针进行查找，相等则归入结果，不等移动小的指针
     * 1ms  99.99
     * 38.5Mb  69.3
     *
     * @return
     */
    public int[] intersect(int[] nums1, int nums2[]) {
        int loc = Math.max(nums1.length, nums2.length);
        int i = 0, j = 0;
        int[] temp = new int[loc], result;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        loc = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[loc++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        result = new int[loc];
        for (i = 0; i < loc; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /**
     * 哈希  使用map进行统计
     *  2ms
     *
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mymap = new HashMap<>();
        int i = 0, j = 0, loc = Math.max(nums1.length, nums2.length);
        int[] temp = new int[loc], result;
        //使用map统计nums1中每个元素出现的次数
        while (i < nums1.length) {
            if (!mymap.containsKey(nums1[i])) {
                mymap.put(nums1[i], 1);
            } else {
                int times = mymap.get(nums1[i]) + 1;
                mymap.put(nums1[i], times);
            }
            i++;
        }
        loc = 0;
        //遍历nums2统计该元素是否在 nums1 中出现
        while (j < nums2.length) {
            if (mymap.containsKey(nums2[j])) {
                temp[loc++] = nums2[j];
                int times = mymap.get(nums2[j]) - 1;
                if (times == 0) {
                    mymap.remove(nums2[j]);
                } else {
                    mymap.put(nums2[j], times);
                }
            }
            j++;
        }
        // 返回结果
        result = new int[loc];
        for (i = 0; i < loc; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    /**
     * 哈希  优化map的应用
     *  3ms 50.1
     *  38.4
     * @return
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mymap = new HashMap<>();
        int i = 0, j = 0, loc = Math.max(nums1.length, nums2.length);
        int[] temp = new int[loc], result;
        //使用map统计nums1中每个元素出现的次数
        while (i < nums1.length) {
            mymap.put(nums1[i], mymap.getOrDefault(nums1[i++], 0) + 1);
        }
        loc = 0;
        //遍历nums2统计该元素是否在 nums1 中出现
        while (j < nums2.length) {
            if (mymap.getOrDefault(nums2[j], 0) > 0) {
                temp[loc++] = nums2[j];
                mymap.put(nums2[j], mymap.getOrDefault(nums2[j], 0) - 1);
            }
            j++;
        }
        // 返回结果
        result = new int[loc];
        for (i = 0; i < loc; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Test
    public void mytest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 1, 1};
        int[] result;
        result = intersect(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}