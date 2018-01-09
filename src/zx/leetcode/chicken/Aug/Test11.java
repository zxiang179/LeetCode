package zx.leetcode.chicken.Aug;
/**
 * 400. Nth Digit
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test11 {
	
	/**
	 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
		int len = 1;
		int start = 1;
		long count = 9;
		while(n>len*count){
			n -= len*count;
			len++;
			count *=10;
			start *=10;
		}
		//确定是哪个数
		start +=(n-1)/len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n-1)%len));
    }

}
