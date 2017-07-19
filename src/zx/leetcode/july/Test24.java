package zx.leetcode.july;

/**
 * 397. Integer Replacement
 * @author Carl_Hugo
 */
public class Test24 {
    
	public int integerReplacement(int n) {
		if(n==Integer.MAX_VALUE)return 32;
		int count = 0;
		while(n!=1){
			if(n%2==0){
				n=n>>1;
			}else{
				if((n-1)%4==0||n==3){
					n=n-1;
				}else{
					n=n+1;
				}
			}
			count++;
		}
        return count;
    }
	
}
