package zx.leetcode.chicken.restart;

import org.junit.Test;

public class Move_Zeroes {
	
	 public void moveZeroes(int[] nums) {
		 int count = 0;
		 int countZero = 0;
		 for(int i=0;i<nums.length;i++){
			 if(nums[i]!=0){
				 nums[count++] = nums[i];
			 }else{
				 countZero++;
			 }
		 }
		 for(int i=nums.length-countZero;i<nums.length;i++){
			 nums[i] = 0;
		 }
		 System.out.println();
	 }
	 
	 @Test
	 public void test(){
		 moveZeroes(new int[]{0, 1, 0, 3, 12});
	 }

}
