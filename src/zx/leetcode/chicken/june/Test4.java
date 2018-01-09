package zx.leetcode.chicken.june;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * @author Carl_Hugo
 * @date 2017年6月27日
 */
public class Test4 {
	
	/**
	 * Given an integer array, 
	 * find three numbers whose product is maximum and output the maximum product.
	 * @param nums
	 * @return
	 */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int b = nums[0]*nums[1]*nums[nums.length-1];
        return a>b?a:b;
    }

}
