package zx.leetcode.dog.feb;

public class Perfect_Squares_279 {
	
	/**
	 * dp[i]表示组成i最少需要的平方数个数
	 * 边界
	 * dp[1]=1
	 * dp[2]=dp[1]+dp[1]=2
	 * 
	 * 状态转移方程
	 * dp[i]=dp[target-k]+dp[k]  for(k=1;k<i;k++)
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		//DP边界处理
		for(int i=1;i<=n;i++){
			int sqrtI = (int)Math.sqrt(i);
			if(sqrtI*sqrtI==i){
				dp[i]=1;
			}
		}
		
		for(int i=2;i<=n;i++){
			int min = Integer.MAX_VALUE;
			if(dp[i]!=1){
				for(int k=1;k<=i;k++){
					int temp = dp[i-k] + dp[k];
					if(temp<min){
						min = temp;
						dp[i] = min;
					}
				}
			}
		}
		return dp[n];
    }
	
	public static void main(String[] args) {
		new Perfect_Squares_279().numSquares(1);
	}

}
