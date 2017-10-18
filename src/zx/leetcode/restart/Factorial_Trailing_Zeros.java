package zx.leetcode.restart;

public class Factorial_Trailing_Zeros {
	
	public int trailingZeroes(int n) {
		int result = 0;
		while(n>0){
			n=n/5;
			result+=n;
		}
		return result;
	}

}
