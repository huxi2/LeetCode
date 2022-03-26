package dp;

public class ClimbStairs {

    public int climbStairs(int n) {
        // 当到低x台阶的时候,只有两种情况
        // 下一节台阶走一步，下两节台阶走两步
        // 因此第x个台阶进和x-1，x-2相关。
        // pd[i] = dp[i-1] + dp[i-1]
        // dp[0]=1,dp[1]=2
        // 时间空间 O(n)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    //优化空间复杂度
    public int climbStairs2(int n) {
        //时间O(n) 空间O(1)
        int previous=1,current=1;
        for(int i=1;i<n;i++){
            current = previous+current;
            previous = current-previous;
        }
        return current;
    }
}
