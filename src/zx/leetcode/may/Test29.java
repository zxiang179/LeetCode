package zx.leetcode.may;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * @author Carl_Hugo
 * @date 2017年5月27日
 */
public class Test29 {

	public int minMoves2(int[] nums) {
        int i,j,count;
        i=0;
        count=0;
        j=nums.length-1;
        Arrays.sort(nums);
        while(i<j){
        	count+=nums[j]-nums[i];
        	i++;
        	j--;
        }
        return count/2;
    }
	
}
