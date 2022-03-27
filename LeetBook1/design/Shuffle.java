package design;

import java.util.Random;

public class Shuffle {

    private int[] original = null;
    private final Random random = new Random();

    public Shuffle(int[] nums) {
        original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        // 数组拷贝
        int[] res = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            res[i] = original[i];
        }
        //确保每个位置都交换到
        for (int i = 0; i < res.length; i++) {
            int random_loc = random.nextInt(res.length);
            int temp = res[i];
            res[i] = res[random_loc];
            res[random_loc] = temp;
        }
        return res;
    }

}
