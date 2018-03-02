package zx.leetcode.dog.feb;

public class Maximum_Length_of_Repeated_Subarray_718 {
	
	/**
	 * dp[i][j]表示数组A前i个数字与数组B前j个数字中的最长重复子串的长度
	 * 边界
	 * dp[0][0]=0;
	 * 状态转移方程
	 * dp[i][j] = A[i]==B[j]?dp[i-1][j-1]+1:0(要求连续，一旦有不一样就为0)
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLength(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m+1][n+1];
		dp[0][0]=0;
		int max = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = A[i-1]==B[j-1]?(dp[i-1][j-1]+1):0;
				if(dp[i][j]>max)max = dp[i][j];
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		new Maximum_Length_of_Repeated_Subarray_718().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
	}

}
