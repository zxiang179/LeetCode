package zx.leetcode.dog.feb;

public class Minimum_Path_Sum_64 {
	
	/**
	 * dp[i][j]表示走到该位置最短的路径之和
	 * 状态转移方程
	 * dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1]
	 * 边界
	 * dp[0][i]=sum(grid[0][j]) for(j=0;j<grid[0].length;j++)
	 * dp[i][0]=sum(grid[i][0]) for(i=0;i<grid.length;i++)
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for(int i=1;i<m;i++){
			dp[i][0] = dp[i-1][0]+grid[i][0];
		}
		for(int j=1;j<n;j++){
			dp[0][j] = dp[0][j-1]+grid[0][j];
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
			}
		}
        return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		new Minimum_Path_Sum_64().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
	}

}
