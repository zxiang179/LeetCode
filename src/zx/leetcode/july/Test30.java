package zx.leetcode.july;
/**
 * 263. Ugly Number
 * @author Carl_Hugo
 * 2017年7月24日 下午6:37:09
 */
public class Test30 {
	
	/**
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
	 * @param num
	 * @return
	 */
    public boolean isUgly(int num) {
    	if(num==0)return false;
    	if(num==1)return true;
    	int temp = num;
    	while(temp!=1){
    		if(temp%2==0){
    			temp/=2;
    		}else if(temp%3==0){
    			temp/=3;
    		}else if(temp%5==0){
    			temp/=5;
    		}else{
    			return false;
    		}
    	}
    	return true;
    }

}
