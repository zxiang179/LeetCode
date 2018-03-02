package zx.leetcode.dog.feb;

public class Unique_Paths_62 {
	
	/**
	 * 递推公式dp[i][j]=dp[i][j-1]+dp[i-1][j]
	 * 边界
	 * dp[i][0]=1
	 * dp[0][j]=1
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
        	dp[i][0] = 1;
        	for(int j=1;j<=n;j++){
        		dp[0][j] = 1;
        		dp[i][j]=dp[i][j-1]+dp[i-1][j];
        	}
        }
        return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new Unique_Paths_62().uniquePaths(3, 7));
	}

}
