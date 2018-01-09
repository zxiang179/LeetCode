package zx.leetcode.chicken.Aug;
/**
 * 565. Array Nesting
 * @author Carl_Hugo
 * @date 2017年8月31日
 */
public class Array_Nesting {
	
    public int arrayNesting(int[] nums) {
    	int maxSize = 0;
    	for(int i=0;i<nums.length;i++){
    		int size = 0;
    		for(int k=i;nums[k]>=0;){
    			int ak = nums[k];
    			nums[k]=-1;
    			size++;
    			k = ak;
    		}
    		maxSize = Math.max(maxSize, size);
    	}
        return maxSize;
    }

}
