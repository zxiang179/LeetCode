package zx.leetcode.Aug;
/**
 * 278. First Bad Version
 * @author Carl_Hugo
 * @date 2017年8月15日
 */
public class Test5 {

	/**
	 * 如果中间的一个版本是正确的，则之前的版本都是正确的，错误版本只可能在后半段
	 * @param n
	 * @return
	 */
    public int firstBadVersion(int n) {
    	int start = 1;
    	int end = n;
    	while(start<end){
    		int mid = start+(end-start)/2;
    		if(!isBadVersion(mid)){
    			start=mid+1;	
     		}else{
    		    end = mid;	
    		}
    	}
        return start;
    }
    
    public boolean isBadVersion(int n){
    	return true;
    }

}
