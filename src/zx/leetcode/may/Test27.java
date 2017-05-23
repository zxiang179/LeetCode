package zx.leetcode.may;
/**
 * 357. Count Numbers with Unique Digits
 * @author Carl_Hugo
 * @date 2017年5月23日
 */
public class Test27 {

	/**
	 * f(1)=10
	 * f(2)=9*9
	 * f(3)=f(2)*8=9*9*8
	 * f(4)=f(3)*7=9*9*8*7
	 * f(5)=f(4)*6=9*9*8*7*6
	 * f(6)=f(5)*5=9*9*8*7*6*5
	 * f(7)=f(6)*4=9*9*8*7*6*5*4
	 * f(8)=f(7)*3=9*9*8*7*6*5*4*3
	 * f(9)=f(8)*2=9*9*8*7*6*5*4*3*2
	 * f(10)=f(9)*1=9*9*8*7*6*5*4*3*2*1
	 * f(11)=f(9)*0=0=f(12)...
	 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
	 * @param n
	 * @return
	 */
    public int countNumbersWithUniqueDigits(int n) {
    	int[] count = new int[11];
        int product = 9;
        int res=0;
        if(n==0)return 1;
        if(n==1)return 10;
        count[1]=10;
        count[2]=9*9;
        for(int i=3;i<=10;i++){
        	--product;
        	count[i]=count[i-1]*product;
        }
        if(n>=10)return 0;
        
        for(int i=1;i<=n;i++){
        	res+=count[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
		new Test27().countNumbersWithUniqueDigits(3);
	}

}
