package zx.leetcode.chicken.apri;

/**
 * 122. Best Time to Buy and Sell Stock II
 * @author Carl_Hugo
 */
public class Test20 {
	
	/**
	 * 你必须在再次购买前出售股票
	 * 本题由于是可以操作任意次数，只为获得最大收益，而且对于一个上升子序列，比如：[5, 1, 2, 3, 4]中的1, 2, 3, 4序列来说，
	 * 对于两种操作方案：1 在1买入，4卖出
	 * 2 在1买入，2卖出同时买入，3卖出同时买入，4卖出
	 * 这两种操作下，收益是一样的。
	 * 所以可以从头到尾扫描prices，如果price[i] – price[i-1]大于零则计入最后的收益中。即贪心法
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
        	if(prices[i+1]-prices[i]>0){
        		profit +=(prices[i+1]-prices[i]);
        	}
        }
        return profit;
    }
    
    public static void main(String[] args) {
		Test20 test20 = new Test20();
		System.out.println(test20.maxProfit(new int[]{5, 1, 2, 3, 4}));
	}

}
