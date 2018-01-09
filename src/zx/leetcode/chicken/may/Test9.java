package zx.leetcode.chicken.may;
/**
 * 367. Valid Perfect Square
 * @author Carl_Hugo
 * @date 2017年5月4日
 */
public class Test9 {
	
	/**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
	 * @param num
	 * @return
	 */
    public boolean isPerfectSquare(int num) {
        int i;
    	for(i=1;i<=num/2;i++){
        	if(i*i>=num)break;
        }
    	if(i*i==num)return true;
    	return false;
    }

}
