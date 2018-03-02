package zx.leetcode.dog.feb;

import java.util.Arrays;

public class Coin_Change_322 {
	
	/**
	 * dp[i]表示组成amount需要最少的零钱数量
	 * 状态转移方程
	 * dp[i] = min(dp[i],dp[i-coins[k]]+1)  i>=coins[k]
	 * 
	 * 边界
	 * dp[0] = 0;
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if(amount<0)return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
        	for(int j=0;j<coins.length;j++){
        		if(i>=coins[j]){
        			dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
        		}
        	}
        }
		return (dp[amount]==amount+1)?-1:dp[amount];
    }
	
	public static void main(String[] args) {
		new Coin_Change_322().coinChange(new int[]{1,2,5}, 3);
	}

}
