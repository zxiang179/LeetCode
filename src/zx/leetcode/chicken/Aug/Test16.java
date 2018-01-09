package zx.leetcode.chicken.Aug;
/**
 * 540. Single Element in a Sorted Array
 * @author Carl_Hugo
 * @date 2017年8月20日
 */
public class Test16 {
	
    /**
     * 找出数组中唯一一个只出现一次的数，其余数均出现两次
     * Your solution should run in O(log n) time and O(1) space.
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
    	int n = nums.length;
    	int lo = 0;
    	int hi = n/2;
    	while(lo<hi){
    		int m = (lo+hi)/2;
    		if(nums[m*2]!=nums[m*2+1]){
    			//前半段有问题
    			hi = m;
    		}else{
    			lo = m+1;
    		}
    	}
    	return nums[2*lo];
    }

}
