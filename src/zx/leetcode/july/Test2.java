package zx.leetcode.july;

/**
 * 342. Power of Four 
 * @author Carl_Hugo
 * @date 2017年7月1日
 */
public class Test2 {
	
	public boolean isPowerOfFour(int num) {
	    int tmp = num;
	    if(tmp>1){
	    	while(tmp%4==0)tmp/=4;
	    }
		return tmp==1;
    }

}
