package zx.leetcode.dog.yuanjiing;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		System.out.println(minimumDeleteSum(s1, s2));
	}
	
	public static int minimumDeleteSum(String s1, String s2) {
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
	
	public static int callStringDistance(String charA,String charB){
		int m = charA.length();
		int n = charB.length();
		int[][] dp = new int[m+1][n+1];
		//初始化动态数组
		for(int j=1;j<=n;j++){
			dp[0][j] = dp[0][j-1] + charB.charAt(j-1);
		}
		for(int i=1;i<=m;i++){
			dp[i][0] = dp[i-1][0] + charA.charAt(i-1);
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int temp = charA.charAt(i-1)==charB.charAt(j-1)?0:charA.charAt(i-1)+charA.charAt(j-1);
				dp[i][j] = Math.min(dp[i-1][j-1]+temp, Math.min(dp[i-1][j]+charA.charAt(i-1), dp[i][j-1]+charB.charAt(j-1)));
			}
		}
		return dp[m][n];
	}

}
