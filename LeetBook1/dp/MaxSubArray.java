package dp;

public class MaxSubArray {
    //思路：dp[i] 表示以i为结尾的连续子序列最大的和
    //  两种情况  i天是连续的(dp[i-1]+nums[i])，i天不连续(nums[i])
    //  dp[i] = max(dp[i-1]+nums[i],nums[i]
    //时空O(N)
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxNum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > maxNum) {
                maxNum = dp[i];
            }
        }
        return maxNum;
    }

    //时O(N) O(1)
    public int maxSubArray2(int[] nums) {
        int dp = nums[0];
        int maxNum = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (dp > maxNum) {
                maxNum = dp;
            }
        }
        return maxNum;
    }
}
