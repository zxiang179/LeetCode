package zx.leetcode.may;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * @author Carl_Hugo
 * @date 2017年5月18日
 */
public class Test22 {
	
	/**
	 * Given an array of n integers where n > 1, nums, 
	 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
	 * For example, given [1,2,3,4], return [24,12,8,6].
	 * @param nums
	 * @return
	 */
    public int[] productExceptSelf(int[] nums) {
        int productAll =1;
        int countZero = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		countZero++;
        		continue;
        	}
        	productAll *= nums[i];
        }
        
        if(countZero>=2){
        	Arrays.fill(nums, 0);
        }else if(countZero==1){
        	for(int i=0;i<nums.length;i++){
        		nums[i] = (nums[i]==0)?(nums[i]=productAll):(nums[i]=0);
            }
        }else{
        	for(int i=0;i<nums.length;i++){
            	nums[i] = productAll/nums[i];
            }
        }
        return nums;
    }

}
