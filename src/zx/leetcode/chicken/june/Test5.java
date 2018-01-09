package zx.leetcode.chicken.june;

/**
 * 198. House Robber
 * @author Carl_Hugo
 * @date 2017年6月27日
 */
public class Test5 {
	/**
	 * Each house has a certain amount of money stashed, 
	 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
	 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
       int notrob = 0;
       int rob = 0;
       for(int i=0;i<nums.length;i++){
    	   int currrob = notrob+nums[i];
    	   notrob = Math.max(notrob, rob);
    	   rob = currrob;
       }
       return Math.max(notrob, rob);
    }

}
