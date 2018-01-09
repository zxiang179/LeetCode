package zx.leetcode.chicken.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * @author Carl_Hugo
 * @date 2017年5月17日
 */
public class Test21 {
	
	/**
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * Find all the elements that appear twice in this array.
     * Could you do it without extra space and in O(n) runtime?
	 * @param nums
	 * @return
	 */
    public List<Integer> findDuplicates(int[] nums) {
        int[] hash = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int num:nums){
        	hash[num-1]++;
        }
        for(int i=0;i<hash.length;i++){
        	if(hash[i]==2){
        		list.add(i+1);
        	}
        }
        return list;
    }

}
