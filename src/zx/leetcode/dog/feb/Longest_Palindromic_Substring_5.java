package zx.leetcode.dog.feb;

public class Longest_Palindromic_Substring_5 {
	
	/**
	 * dp[i][j]表示子串从i~j是否为回文字符串
	 * dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n+1][n+1];
		int start = 0;
		int maxLen = 1;
		int len = 3;
		//DP初始化
		for(int i=0;i<s.length()-1;i++){
			dp[i][i] = true;
			if(s.charAt(i)==s.charAt(i+1)){
				dp[i][i+1] = true;
				maxLen = 2;
				start = i;
			}
		}
		
		for(;len<=n;len++){
			for(int i=0;i<=n-len;i++){
				int j = i+len-1;
				if(dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
					dp[i][j] = true;
                    if(maxLen<len){
                        maxLen = len;
					    start = i;   
                    }
				}
			}
		}
        return s.substring(start,start+maxLen);
    }
	
	public static void main(String[] args) {
		System.out.println(new Longest_Palindromic_Substring_5().longestPalindrome("bananas"));
	}

}
