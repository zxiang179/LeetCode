package zx.leetcode.restart;
/**
 * 
 * @author Carl_Hugo
 * 2017年10月13日 上午11:07:19
 */
public class Power_of_Two {
	
	public boolean isPowerOfTwo(int n) {
		if(n<=0)return false;
		int count = 0;
		while(n>0){
			if((n&1)==1){
				count++;
			}
			n=n>>1;
		}
		return count==1?true:false;
    }
	
}
