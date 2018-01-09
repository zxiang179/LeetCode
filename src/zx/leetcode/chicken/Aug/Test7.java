package zx.leetcode.chicken.Aug;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test7 {
	 
	/**
	 * find one continuous subarray that if you only sort this subarray in ascending order, 
	 * then the whole array will be sorted in ascending order, too. 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray(int[] nums) {
	    int[] copyArray = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyArray);
		int start = -1, end = -1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=copyArray[i]){
				if(start==-1)start = i;
				end = i;
			}
		}
		if(start==-1&&end==-1)return 0;
		return end-start+1;
	}

}
