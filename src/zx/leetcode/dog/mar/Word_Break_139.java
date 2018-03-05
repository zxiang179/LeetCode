package zx.leetcode.dog.mar;

import java.util.Arrays;
import java.util.List;

public class Word_Break_139 {
	
	/**
	 * dp[i] 表示字符串0~i-1能够被字典中的单词分割
	 * 
	 * 状态转移方程
	 * dp[i] = dp[j]&(string[j-1,i] in wordDict) (0<j<i)
	 * 
	 * 边界
	 * dp[0] = false;
	 * dp[i] = true  string[0~i] in wordDict
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		if(wordDict==null||wordDict.size()==0||s==null||s.length()==0)return false;
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		
		for(int i=0;i<n;i++){
			if(wordDict.contains(s.substring(0, i+1)))dp[i+1]=true;
			for(int j=0;j<=i;j++){
				String subStr = s.substring(j, i+1);
				dp[i+1] = dp[i+1]||(dp[j]&&wordDict.contains(subStr));
			}
		}
        return dp[n];
    }
	
	public static void main(String[] args) {
		List<String> wordDict = Arrays.asList(new String[]{"a"});
		String s = "a";
		System.out.println(new Word_Break_139().wordBreak(s, wordDict));
		
	}

}
