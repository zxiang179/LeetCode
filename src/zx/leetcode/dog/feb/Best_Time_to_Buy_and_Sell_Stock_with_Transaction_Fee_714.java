package zx.leetcode.dog.feb;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {
	
	/**
	 * 
	 * 对于第i天共有两种情况买或者卖或者什么都不做
	 * 最优子结构和状态转移方程
	 * 第i天买收益最大,第i-1天买了收益最大或者第i-1天卖了的收益
	 *  buy[i] = max(buy[i-1],sell[i-1]-prices[i])
	 * 第i天卖收益最大,第i-1天卖了收益最大或者第i-1天买了的收益
	 * sell[i] = max(sell[i-1],buy[i-1]+prices[i]-fee)
	 * 边界条件
	 * buy[0]=-price[0]
	 * sell[0]=0;
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[] buy = new int[n+1];
		int[] sell = new int[n+1];
		buy[0] = -prices[0];
		sell[0] = 0;
		for(int i=1;i<n;i++){
			buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
			sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
		}
        return sell[n-1];
    }
	
	public static void main(String[] args) {
		int[] inputArr = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714().maxProfit(inputArr, fee));
	}

}
