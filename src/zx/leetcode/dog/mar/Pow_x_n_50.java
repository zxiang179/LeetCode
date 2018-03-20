package zx.leetcode.dog.mar;

public class Pow_x_n_50 {
	
	/**
	 * Input: 2.00000, 10
     * Output: 1024.00000
     * 
     * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if(n==Integer.MIN_VALUE){
			return x==1||x==-1?1:0;
		}
		if(n==0){
			return 1;
		}
		if(n==1){
			return x;
		}
		if(n<0){
            n = -n;
            x = 1/x;
        }
		double result = myPow(x,n/2);
		result *=result;
		if(n%2==1){
			result = result*x;
		}
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new Pow_x_n_50().myPow(2, 10));
	}

}
