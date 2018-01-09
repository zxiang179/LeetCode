package zx.leetcode.chicken.restart;

import org.junit.Test;

public class Third_Maximum_Number {
	
	public int thirdMax(int[] nums) {
		Integer first = null;
		Integer second = null;
		Integer third = null;

		for(int i=0;i<nums.length;i++){
			if(first==null||nums[i]>first){
				third = second;
				second = first;
				first = nums[i];
			}else if(second==null||nums[i]>second){
				if(nums[i]==first)continue;
				third = second;
				second = nums[i];
			}else if(third==null||nums[i]>third){
				if(nums[i]==second)continue;
				third = nums[i];
			}
		}
        return third==null?first:third;				
	}
	
	@Test
	public void test(){
		thirdMax(new int[]{2,3,2,1});
	}

}
