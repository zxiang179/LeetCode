package zx.leetcode.dog.jan;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 {
	
	/**
	 * 通过动态规划实现，用二维数组dp[i][j]表示将字符串1的前i个字符串实现到字符串2的前j个字符串相同所需要的添加的ASCII的总和
	 * 删除ACSII有三种方式
	 * 1. dp[i-1][j] + str1[i] = dp[i][j]
	 * 2. dp[i][j-1] + str2[j] = dp[i][j];
	 * 3. dp[i-1][j-1] = (str1[i]==str2[j]?0:str1[i]+str2[j])
	 * @param args
	 */
	public int minimumDeleteSum(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		//初始化动态数组
		for(int j=1;j<=n;j++){
			dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
		}
		for(int i=1;i<=m;i++){
			dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int temp = s1.charAt(i-1)==s2.charAt(j-1)?0:s1.charAt(i-1)+s2.charAt(j-1);
				dp[i][j] = Math.min(dp[i-1][j-1]+temp, Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1)));
			}
		}
		return dp[m][n];
	}

}
