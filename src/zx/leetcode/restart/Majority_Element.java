package zx.leetcode.restart;

public class Majority_Element {
	
	public int majorityElement(int[] nums) {
		int times = 1;
		int c = nums[0];
		
		for(int i=1;i<nums.length;i++){
			if(nums[i]==c){
				times++;
			}else{
				times--;
				if(times==0){
					c = nums[i];
					times = 1;
				}
			}
		}
		
		int count = 0;
		if(times>=1){
			for(int i=0;i<nums.length;i++){
				if(c==nums[i])count++;
			}
		}
		if(count>=nums.length/2){
			return c;	
		}else{
			return -1;
		}
    }

}
