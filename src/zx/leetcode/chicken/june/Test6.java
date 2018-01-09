package zx.leetcode.chicken.june;
/**
 * 326. Power of Three
 * @author Carl_Hugo
 * @date 2017年6月28日
 */
public class Test6 {
	
	/**
	 * Given an integer, write a function to determine if it is a power of three.
	 * @param n
	 * @return
	 */
    public boolean isPowerOfThree(int n) {
        return (n>0&&1162261467%n==0);
    }
    
    public boolean isPowerOfThree2(int n) {
        if(n>1){
        	while(n%3==0)n/=3;
        }
        return n==1;
    }

}
