package zx.leetcode.chicken.may;
/**
 * 343. Integer Break
 * @author Carl_Hugo
 * @date 2017年5月25日
 */
public class Test28 {
	
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
        	for(int j=1;j<i;j++){
        		dp[i]=Math.max(dp[i], (Math.max(dp[j], j)*Math.max(dp[i-j], i-j)));
        	}
        }
        return dp[n];
    }

}
