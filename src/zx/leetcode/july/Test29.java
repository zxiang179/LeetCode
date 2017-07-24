package zx.leetcode.july;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * @author Carl_Hugo
 *
 */
public class Test29 {
	
	/**
	 * Given a binary array, 
	 * find the maximum length of a contiguous subarray with equal number of 0 and 1.
	 * @param nums
	 * @return
	 */
    public int findMaxLength(int[] nums) {
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0)nums[i]=-1;
    	}
        Map<Integer, Integer> sum2Index = new HashMap<Integer,Integer>();
        sum2Index.put(0, -1);
        int sum = 0, max = 0;
        for(int i=0;i<nums.length;i++){
        	sum+=nums[i];
        	if(sum2Index.containsKey(sum)){
        		max = Math.max(max, i-sum2Index.get(sum));
        	}else{
        		sum2Index.put(sum, i);
        	}
        }
        return max;
    }

}
