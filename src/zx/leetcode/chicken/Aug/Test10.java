package zx.leetcode.chicken.Aug;
/**
 * 400. Nth Digit
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test10 {
	
	/**
	 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	 * @param n
	 * @return
	 */
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        for(Integer i=1;i<=n;i++){
        	sb.append(i.toString());
        }
        return sb.charAt(n-1)-'0';
    }

    public static void main(String[] args) {
		System.out.println(new Test10().findNthDigit(11));
	}
}
