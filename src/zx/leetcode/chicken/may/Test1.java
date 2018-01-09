package zx.leetcode.chicken.may;
/**
 * 70. Climbing Stairs
 * @author Carl_Hugo
 */
public class Test1 {

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 使用Fibonacci数列
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
        if(n==0||n==1||n==2)return n;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for(int i=3;i<=n;i++){
        	res[i] = res[i-1]+res[i-2];
        }
        return res[n];
    }
    
    public static void main(String[] args) {
		Test1 test1 = new Test1();
		System.out.println(test1.climbStairs(15));
	}

}
