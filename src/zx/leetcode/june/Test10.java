package zx.leetcode.june;

/**
 * 69. Sqrt(x)
 * @author Carl_Hugo
 * @date 2017年6月30日
 */
public class Test10 {
	
	/**
	 * 二分查找
	 * @param x
	 * @return
	 */
    public int mySqrt(int x) {
        if(x==0)return 0;
        int left=1,right=Integer.MAX_VALUE;
        while(true){
        	int mid=left+(right-left)/2;
        	if(mid>x/mid){
        		right=mid-1;
        	}else{
        		if(mid+1>x/(mid+1)){
        			return mid;
        		}
        		left=mid+1;
        	}
        }
    }

}
