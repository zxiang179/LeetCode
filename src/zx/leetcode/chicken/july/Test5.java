package zx.leetcode.chicken.july;
/**
 * 121. Best Time to Buy and Sell Stock
 * @author Carl_Hugo
 * @date 2017年7月4日
 */
public class Test5 {
	
	/**
	 * Dynamic Programming
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        int curProf = 0;
        int sofarProf = 0;
        for(int i=1;i<prices.length;i++){
        	curProf = Math.max(0, curProf+=(prices[i]-prices[i-1]));
        	sofarProf = Math.max(sofarProf, curProf);
        }
        return sofarProf;
    }

}
