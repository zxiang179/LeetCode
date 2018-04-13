package zx.leetcode.dog.apri;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int len = prices.length;
		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;
		int sell1 = 0;
		int sell2 = 0;
		for (int i = 0; i < prices.length; i++) {
			sell2 = Math.max(sell2, buy2 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy1 = Math.max(buy1, -prices[i]);
		}
		return sell2;
	}

}
