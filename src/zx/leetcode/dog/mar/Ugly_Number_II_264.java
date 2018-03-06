package zx.leetcode.dog.mar;

public class Ugly_Number_II_264 {
	
	/**
	 * dp[i] 表示第i个uglyNumber
	 * 
	 * 边界
	 * dp[1] = 1
	 * dp[2] = 2
	 * dp[3] = 3
	 * dp[5] = 5
	 * 
	 * 状态转移方程
	 * dp[i] = min(dp[i-1]*2,dp[i-2]*3,dp[i-3]*5)
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[5] = 5;
        for(int i=4;i<=n;i++){
        	dp[i] = Math.min(dp[i-1]*2,Math.min(dp[i-2]*3,dp[i-3]*5));
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		new Ugly_Number_II_264().nthUglyNumber(10);
	}

}
