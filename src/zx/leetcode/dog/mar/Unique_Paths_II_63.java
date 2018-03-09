package zx.leetcode.dog.mar;

public class Unique_Paths_II_63 {

	/**
	 * dp[i][j] 表示走到i，j位置的总的路径数量
	 * 
	 * dp[i][j] = dp[i-1][j]+dp[i][j-1] if(obstacleGrid[i][j]!=1) 
	 * if(obstacleGrid[i][j]==1) dp[i][j] = 0
	 * 
	 * 边界
	 * dp[i][0] = 1  if(obstacleGrid[k][0]==0)  0<k<i
	 * dp[i][0] = 0  if(obstacleGrid[k][0]==1)  0<k<i
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];
		boolean noObstacle = true;
		for(int i=0;i<n;i++){
			if(obstacleGrid[i][0]==1)noObstacle = false;
			if(obstacleGrid[i][0]==0&&noObstacle){
				dp[i][0] = 1;
			}else{
				dp[i][0] = 0;
			}
		}
		noObstacle = true;
		for(int j=0;j<m;j++){
			if(obstacleGrid[0][j]==1)noObstacle = false;
			if(obstacleGrid[0][j]==0&&noObstacle){
				dp[0][j] = 1;
			}else{
				dp[0][j] = 0;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				}
				if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		new Unique_Paths_II_63().uniquePathsWithObstacles(
				new int[][]{{0,0,0},
				  {0,1,0},
				  {0,0,0}});
	}
}
