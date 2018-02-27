package zx.leetcode.dog.feb;

import java.util.Arrays;

public class Keys_Keyboard_650 {
	
	/**
	 * dp[i]代表将字符串复制n次所需的最少操作
	 * 初始化将dp数组中的值都赋为-1
	 * dp[0]、dp[1]均为0
	 * 如果i%j==0,则dp[i] = min(dp[i],dp[j]+i/j-1+1)，dp[i]可以通过复制dp[j]一次,粘贴i/j-1次得到dp[i] 
	 * @param n
	 * @return
	 */
	public int minSteps(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<n+1;i++){
			for(int j=i-1;j>=1;j--){
				if(i%j==0){
					dp[i] = Math.min(dp[i], dp[j]+i/j);
				}
			}
		}
		return dp[n];
    }
	
	public static void main(String[] args) {
		System.out.println(new Keys_Keyboard_650().minSteps(3));
	}

}
