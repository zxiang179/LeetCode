package zx.leetcode.july;
/**
 * 202. Happy Number
 * @author Carl_Hugo
 * @date 2017年7月4日
 */
public class Test6 {
	
	/**
	 * 19 is a happy number
	 * @param n
	 * @return
	 */
    public boolean isHappy(int n) {
    	int result=n;
    	boolean isOne = false;
        for(int i=0;i<10;i++){
        	result = splitDigitSum(result);
        	if(result==1){
        		isOne = true;
        		break;
        	}
        }
        return isOne;
    }
    
    public int splitDigitSum(int num){
    	int sum = 0;
    	int temp = num;
    	while(temp>0){
    		int digit = temp%10;
    		temp /=10;
    		sum+=digit*digit;
    	}
    	return sum;
    }

}
