package zx.leetcode.dog.feb;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
	
	/**
	 * 对于第i天有三种可能：buy[i]、sell[i]、cooldown[i]
	 * 状态转移方程
	 * buy[i] = max(cooldown[i-1]-prices[i],buy[i-1])
	 * sell[i] = max(buy[i-1]+price[i],sell[i-1])
	 * cooldown[i]=sell[i-1]
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length==0)return 0;
		int n = prices.length;
		int[] buy = new int[n+1];
		int[] sell = new int[n+1];
		int[] cooldown = new int[n+1];
		buy[0] = - prices[0];
		sell[0] = 0;
		cooldown[0] =0;
		for(int i=1;i<prices.length;i++){
			buy[i] = Math.max(cooldown[i-1]-prices[i],buy[i-1]);
			sell[i] = Math.max(buy[i-1]+prices[i],sell[i-1]);
			cooldown[i]=sell[i-1];
		}
        return sell[n-1];
    }
	
	public static void main(String[] args) {
		new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309().maxProfit(new int[]{1, 2, 3, 0, 2});
	}

}
