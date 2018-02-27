package zx.leetcode.dog.feb;

public class Predict_the_Winner_486 {
	
	/**
	 * 通过使用dp[i][j]分别记录两个玩家player1和player2从i~j获取的最大值
	 * player1得到的最大值为正，player2得到的最大值为负，判断dp[0][n-1]最后的正负
	 * 当player1为dp[i][j],则player2为dp[i+1][j]或者为dp[i][j-1]
	 * 取当前能够的添加点-之前dp值的最大值为当前最优
	 * dp[i][j] = max(num[i]-dp[i+1][j],num[j]-dp[i][j-1])
	 * @param nums
	 * @return
	 */
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++){
			dp[i][i] = nums[i];
		}
		for(int len = 1;len<n;len++){
			for(int i=0,j=len;j<n;i++,j++){
				dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
			}
		}
		return dp[0][n-1]>=0;
    }
	
	public static void main(String[] args) {
		int[] input = {1, 5, 233, 7};
		System.out.println(new Predict_the_Winner_486().PredictTheWinner(input));
	}

}
