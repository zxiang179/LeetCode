package zx.leetcode.chicken.restart;

public class Range_Sum_Query {
	
	int sum[];
	public Range_Sum_Query(int[] nums) {
		if(nums!=null&&nums.length!=0){
			sum = new int[nums.length];
			sum[0] = nums[0];
			for(int i=1;i<nums.length;i++){
				sum[i] = sum[i-1]+nums[i];
			}
		}
	}
	
	public int sumRange(int i,int j){
		if(i==0)return sum[j];
		return sum[j]-sum[i-1];
	}
}
