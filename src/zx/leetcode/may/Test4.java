package zx.leetcode.may;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * @author Carl_Hugo
 * @date 2017年5月3日
 */
public class Test4 {
	
	/**
	 * Just try another one like (1, 4) and (2, 3)
     * step one: min(1, 4) = 1, min(2, 3) = 2;
     * step two: add the mins, sum = 1 + 2 = 3;
     * step three: compare this to our best pairs, 3 < 4.
     * Obviously, 4 is larger, so (1, 2) and (3, 4) are better pairs than (1, 4) and (2, 3).
     * The point here is: for each pair, we calculate min(a, b), but for sum of all the mins, we want the largest sum.
	 * @param nums
	 * @return
	 */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
        	sum+=nums[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Test4().arrayPairSum(new int[]{1,2,3,4}));
	}

}
