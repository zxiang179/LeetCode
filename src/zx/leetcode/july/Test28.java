package zx.leetcode.july;
/**
 * 633. Sum of Square Numbers
 * @author Carl_Hugo
 *
 */
public class Test28 {

    public boolean judgeSquareSum(int c) {
    	if(c<0)return false;
    	int left = 0;
    	int right = (int) Math.sqrt(c);
    	while(left<=right){
    		int cur = left*left+right*right;
    		if(cur<c){
    			left++;
    		}else if(cur>c){
    			right--;
    		}else{
    			return true;
    		}
    	}
    	return false;
    }
	
}
