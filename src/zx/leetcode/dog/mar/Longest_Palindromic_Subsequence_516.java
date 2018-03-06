package zx.leetcode.dog.mar;

public class Longest_Palindromic_Subsequence_516 {
	
	/**
	 * dp[i][j] 表示字符串从i~j的最长的回文子序列的长度\
	 * 边界
	 * dp[i][i] = 1  （0<i<s.length-1）
	 * 
	 * 状态转移方程
	 * dp[i][j] = dp[i+1][j-1] + 2              if(s.charAt(i)==s.charAt(j))
	 *            max(dp[i+1][j],dp[i][j-1])    if(s.charAt(i)!=s.charAt(j))
	 * 
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		for(int i=len-1;i>=0;i--){
			dp[i][i] = 1;
			for(int j=i+1;j<=len-1;j++){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}else{
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		return dp[0][len-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new Longest_Palindromic_Subsequence_516().longestPalindromeSubseq("bbbab"));
	}

}
